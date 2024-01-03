package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;

public class JoinMemberActionOK implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			MemberDAO dao = new MemberDAO();
			MemberVO vo = new MemberVO(request.getParameter("id"),
										request.getParameter("pwd"),
										request.getParameter("name"),
										request.getParameter("email"),
										request.getParameter("phone"));
			int re = dao.joinMember(vo);
			String viewPage = "joinMemberOK.jsp";
			if(re!=1) {
				viewPage = "loginError.jsp";
				request.setAttribute("msg","회원가입에 실패하였습니다.");
			}
			return viewPage;
	}

}
