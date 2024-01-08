package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.BookDAO;

public class ListBookAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = null;
		String cname = null;
		String op=null;
		String sname = null;
		
		HttpSession session = request.getSession();
		
		
		if(request.getParameter("sname") != null) {
			sname = request.getParameter("sname");
		}
		
		if(session.getAttribute("keyword") != null) {
			keyword = (String)session.getAttribute("keyword");
			cname = (String)session.getAttribute("cname");
			op = (String)session.getAttribute("op");
		}
		
		
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
			cname = request.getParameter("cname");
			
			if(cname.equals("price")) {
				op = request.getParameter("op");
			}
			
			session.setAttribute("keyword", keyword);
			session.setAttribute("cname", cname);
			session.setAttribute("op", op);
		}
		
		
		String viewPage = "listBook.jsp";
		BookDAO dao = BookDAO.getInstance();
		request.setAttribute("list", dao.findAll(keyword,cname,op,sname));
		return viewPage;
	}
}