package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;

public class ListBoardAction implements SistAction {
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();
		String writer =null;
		int pageNum = 1;
		if(request.getParameter("writer")!=null) {
			writer = request.getParameter("writer");
		}
		int totalPage = dao.getTotalPage(writer);
		
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		if(pageNum>totalPage) {
			pageNum=totalPage;
		}
		request.setAttribute("writer", writer);
		request.setAttribute("list", dao.findAll(pageNum,writer));
		request.setAttribute("totalPage", totalPage);
		return "listBoard.jsp";
	}
}
