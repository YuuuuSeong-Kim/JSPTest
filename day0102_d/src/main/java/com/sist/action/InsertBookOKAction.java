package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class InsertBookOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*5,"UTF-8", new DefaultFileRenamePolicy());
		
		int bookid = Integer.parseInt(multi.getParameter("bookid"));
		String bookname = multi.getParameter("bookname");
		int price = Integer.parseInt(multi.getParameter("price"));
		String publisher = multi.getParameter("publisher");
		String fname = multi.getOriginalFileName("uploadFile");
		BookVO vo = new BookVO(bookid, bookname, price, publisher,fname);
		BookDAO dao = new BookDAO();
		int re = dao.insertBook(vo);
		String viewpage = "error.jsp";
		if(re==1) {
			viewpage = "insertBookOK.jsp";
		}
		return viewpage;
	}

}
