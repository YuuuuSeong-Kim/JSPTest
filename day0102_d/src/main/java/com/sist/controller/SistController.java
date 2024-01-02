package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.DeleteBookAction;
import com.sist.action.DetailBookAction;
import com.sist.action.InsertBookAction;
import com.sist.action.InsertBookOKAction;
import com.sist.action.ListBookAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBookAction;
import com.sist.action.UpdateBookActionOK;

/**
 * Servlet implementation class SistController
 */
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, SistAction> map;
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	map = new HashMap<String, SistAction>();
    	map.put("listBook.do", new ListBookAction());
    	
    	map.put("detailBook.do", new DetailBookAction());
    	
    	map.put("insertBook.do", new InsertBookAction());
    	map.put("insertBookOK.do", new InsertBookOKAction());
    	
    	map.put("updateBook.do", new UpdateBookAction());
    	map.put("updateBookOK.do", new UpdateBookActionOK());
    	
    	map.put("deleteBook.do", new DeleteBookAction());
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
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String viewPage = map.get(cmd).pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
