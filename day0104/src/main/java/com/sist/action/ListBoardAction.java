package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class ListBoardAction implements SistAction {
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		int totalPage = dao.getTotalPage();
		int pageNum = 1;
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(pageNum>totalPage) {
			pageNum=totalPage;
		}
		request.setAttribute("list", dao.findAll(pageNum));
		request.setAttribute("totalPage", dao.getTotalPage());
		return "listBoard.jsp";
	}
}
