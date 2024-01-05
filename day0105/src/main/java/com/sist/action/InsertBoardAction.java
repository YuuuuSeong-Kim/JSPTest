package com.sist.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertBoardAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) {
		int no = 0;
		if(request.getParameter("no")!=null) {
			no = Integer.parseInt(request.getParameter("no"));
		}
		request.setAttribute("no", no);
		return "insertBoard.jsp";
	}

}
