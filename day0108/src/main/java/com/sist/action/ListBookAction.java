package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BookDAO;
import com.sist.vo.BookVO;

public class ListBookAction implements SistAction {
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = null;
		String category = null;
		String op = null;
		String order = null;
		
		HttpSession session = request.getSession();
		
		String ascORdesc="asc";
		if(request.getParameter("snum")==null) {
			request.setAttribute("snum", "2");
			ascORdesc = "desc";
		}else {
			if(request.getParameter("snum").equals("1")) {
				request.setAttribute("snum", "2");
				ascORdesc = "desc";
			}else {
				ascORdesc = "asc";
				request.setAttribute("snum", "1");
			}
		}
		
		if(request.getParameter("order")!=null) {
			order = request.getParameter("order");
			request.setAttribute("order", order);
		}
		
		if(request.getParameter("category")!=null) {
			category = request.getParameter("category");
			request.setAttribute("category", category);
			if(category.equals("price")) {
				op = request.getParameter("op");
				request.setAttribute("op", op);
			}
		}
		
		if(request.getParameter("keyword")!=null) {
			keyword = request.getParameter("keyword");
			request.setAttribute("keyword", keyword);
		}
		
		BookDAO dao = BookDAO.getInstance();
		ArrayList<BookVO> list = dao.findAll(keyword,category,op,order,ascORdesc);
		String viewPage = "listBook.jsp";
		request.setAttribute("list", list);
		return viewPage;
	}
}
