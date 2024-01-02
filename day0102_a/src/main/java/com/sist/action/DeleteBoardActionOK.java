package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class DeleteBoardActionOK implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String path = request.getRealPath("data");
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = dao.detail(no);
		File file = new File(path+"/"+vo.getFname());
		file.delete();
		int re = dao.deleteBoard(no,request.getParameter("pwd"));
		String viewPage = "deleteBoardOK.jsp";
		if(re!=1) {
			viewPage = "deleteBoardFail.jsp";
		}
		return viewPage;
	}
}
