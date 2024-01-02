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

import com.google.gson.Gson;
import com.sist.dao.DeptDAO;
import com.sist.vo.DeptVO;

/**
 * Servlet implementation class listDept
 */
@WebServlet("/listDeptJson")
public class listDeptJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listDeptJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(ServletRequest rep, ServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=utf-8");
		PrintWriter out = res.getWriter();
		ArrayList<DeptVO> list = new DeptDAO().listDept();
		Gson gson = new Gson();
		String dept = gson.toJson(list);
		out.print(dept);
		out.close();
		
	}
}
