package com.sist.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.SistAction;

/**
 * Servlet implementation class SistController
 */
@WebServlet("*.do")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      HashMap<String, SistAction> map;
      
    @Override
	public void init(ServletConfig config) throws ServletException {
    	map = new HashMap<String, SistAction>();
    	try {
			String path = config.getServletContext().getRealPath("WEB-INF");
			FileReader file = new FileReader(path+"/sist.properties");
			Properties prop = new Properties();
			prop.load(file);
			Iterator iter = prop.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				String clsName = (String)prop.get(key);
				SistAction obj = (SistAction)Class.forName(clsName).newInstance();
				map.put(key, obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.indexOf("/",1)+1);
		String viewPage = map.get(cmd).pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
