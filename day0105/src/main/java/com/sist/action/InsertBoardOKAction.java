package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class InsertBoardOKAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		String viewPage = "insertBoardOK.jsp";
		String path = request.getRealPath("data");
		MultipartRequest multi = new MultipartRequest(request, path,1024*1024*5,"utf-8",new DefaultFileRenamePolicy());
		BoardVO b = new BoardVO();
		int no = dao.getNextNO();
		int b_ref = no;
		int b_level = 0;
		int b_step = 0;
		
		int pno = Integer.parseInt(multi.getParameter("no"));
		if(pno!=0) {
			BoardVO vo = dao.detail(pno);
			b_ref=vo.getB_ref();
			b_level=vo.getB_level();
			b_step=vo.getB_step();
			dao.updateStep(b_ref, b_step);
			b_level++;
			b_step++;
		}
		
		b.setNo(no);
		b.setTitle(multi.getParameter("title"));
		b.setWriter(multi.getParameter("writer"));
		b.setPwd(multi.getParameter("pwd"));
		b.setContent(multi.getParameter("content"));
		b.setFname(multi.getOriginalFileName("uploadFile"));
		b.setIp(request.getRemoteAddr());
		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);
		int re = dao.insert(b);
		if (re != 1) {
			viewPage = "../error.jsp";
			request.setAttribute("msg", "게시물 등록에 실패하였습니다.");
		}
		return viewPage;
	}

}
