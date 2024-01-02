package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class DeleteBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRealPath("data");
		System.out.println(path);
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		BookDAO dao = new BookDAO();
		BookVO vo = dao.detailBook(bookid);
		int re = dao.deleteBook(bookid);
		
		File file = new File(path+"/"+vo.getFname());
		String viewpage = "error.jsp";
		System.out.println(path+"/"+vo.getFname());
		if(re==1) {
			viewpage = "deleteBookOK.jsp";
			file.delete();
		}
		return viewpage;
	}

}
