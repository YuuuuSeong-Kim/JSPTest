package com.sist.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.action.DeleteBoardAction;
import com.sist.action.DeleteBoardActionOK;
import com.sist.action.DetailBoardAction;
import com.sist.action.InsertBoardAction;
import com.sist.action.InsertBoardActionOK;
import com.sist.action.ListBoardAction;
import com.sist.action.SistAction;
import com.sist.action.UpdateBoardAction;
import com.sist.action.UpdateBoardActionOK;
import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	HashMap<String, SistAction> map;
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
    	
    	//super.init(config);
    	
    	map = new HashMap<String, SistAction>();
    	map.put("listBoard.do", new ListBoardAction());
    	map.put("insertBoard.do", new InsertBoardAction());
    	map.put("deleteBoard.do", new DeleteBoardAction());
    	map.put("updateBoard.do", new UpdateBoardAction());
    	map.put("detailBoard.do", new DetailBoardAction());
    	
    	map.put("deleteBoardOK.do", new DeleteBoardActionOK());
    	map.put("updateBoardOK.do", new UpdateBoardActionOK());
    	map.put("insertBoardOK.do", new InsertBoardActionOK());
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
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		String viewPage = map.get(cmd).pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
