package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MemberDAO;

public class LoginMemberActionOK implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		int re = dao.loginMember(request.getParameter("id"), request.getParameter("pwd"));
		String viewPage = "";
		String id = request.getParameter("id");
		if(re==1) {
			viewPage="loginMemberOK.jsp";
			request.setAttribute("id", id);
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
		}else {
			viewPage="loginError.jsp";
			request.setAttribute("msg", "로그인에 실패하였습니다.");
		}
		return viewPage;
	}

}
