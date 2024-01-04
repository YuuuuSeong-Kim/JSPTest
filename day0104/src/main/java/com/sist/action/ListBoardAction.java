package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class ListBoardAction implements SistAction {
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		int totalPage = dao.getTotalPage();
		if(request.getParameter("pageNum")==null) {
			pageNum = 1;
		}
		if(pageNum>totalPage) {
			pageNum=totalPage;
		}
		request.setAttribute("list", dao.findAll(pageNum));
		request.setAttribute("totalPage", dao.getTotalPage());
		return "listBoard.jsp";
	}
}
