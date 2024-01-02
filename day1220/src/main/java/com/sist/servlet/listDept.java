package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

/**
 * Servlet implementation class listDept
 */
@WebServlet("/listDept")
public class listDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listDept() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(ServletRequest rep, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		ArrayList<DeptVO> list = new DeptDAO().listDept();
		String dept = "";
		
		for(DeptVO i : list) {
			dept += "<tr><td>"+i.getDno()+"</td><td>"+i.getDname()+"</td><td>"+i.getDloc()+"</td></tr>";
		}
		String str = "<html>"
				+ "<head>"
				+ "<title>모든 부서 목록 불러오기</title>"
				+ "</head>"
				+ "<body>"
				+ "<table border=\"1\">"
				+ "<tr><th>부서번호</th><th>부서명</th><th>지역</th></tr>"
				+ dept
				+ "</table>"
				+ "</body>" 
				+ "</html>";
		out.print(str);
		out.close();
		
	}
}
