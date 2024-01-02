package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Today
 */
@WebServlet("/MyServlet2") // 환경설정
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//super.service(req, res);
		
		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		String data = "";
		data += "<html>";
		data += "<head>";
		data += "<title>서블릿 만들기";
		data += "</title>";
		data += "</head>";
		data += "<body>";
		data += "<h1> 파이팅 코리아!!!";
		data += "</h1>";
		data += "</body>";
		data += "</html>";
		
		out.print(data);
		
		out.close();
	}

}
