package com.sist.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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
	
	//서블릿이 맨 처음 시작이 한번만 동작되는 init에 map의 값을 넣어준다. = 한번만 실행시켜 메모리 절약
    @Override
	public void init(ServletConfig config) throws ServletException {
    	
    	//super.init(config);
    	
    	//서비스 명에 따른 일처리를 다르게 하기 위해 map을 선언하여
    	//key 값에 서비스명을 넣고 value에 담당 객체를 넣어
    	//코드의 가독성을 높인다.
    	map = new HashMap<String, SistAction>();
    	try {
			String path = config.getServletContext().getRealPath("WEB-INF"); 
			//init에는 request가 없기 때문에 sist.properties의 실경로를 알아오기 위해서는 위의 명령어를 써야한다.(sist.properties는 WEB-INF안에 있다)
			FileReader fr = new FileReader(path+"/sist.properties");
			Properties prop = new Properties();
			prop.load(fr);//sist.properties의 내용을 key와 value로 알아서 나눠준다.
			Iterator iter = prop.keySet().iterator(); //key를 하나씩 끄집어내옴
			while(iter.hasNext()) {//hasNext는 boolean을 반환한다. 다음 값이 있으면 true 없으면 false
				String key = (String)iter.next(); //key를 가져와서 key라는 변수에 저장한다.
				String clsName = (String)prop.get(key); //key값으로 sist.properties에 있는 key에 해당하는 value를 가져온다.
				SistAction obj = (SistAction)Class.forName(clsName).newInstance();
				//value를 저장한 clsName으로 Class를 만든다, 이때 Object로 반환되기 때문에 SistAction(모든action의 최고 부모)으로 형변환해준다.
				map.put(key,obj);//위의 key와 클래스객체를 map에 넣어준다
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
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
		//사용자의 uri 를 가져온다
		String uri = request.getRequestURI();
		
		//맨 끝의 서비스명만 추출하여 cmd에 넣는다.
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		
		//해당 서비스명에 대한 객체를 불러와 pro 메소드를 실행하고
		//viewPage에 다음으로 이동할 페이지의 이름을 저장한다.
		String viewPage = map.get(cmd).pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//동일한 일처리가 발생 시 get과 post 방식으로 나누어질 수 있기에
		//모든 일 처리는 get에 작성하고
		//post에선 get을 호출하여 get방식이나 post방식이나 둘 다 get에서 처리되게 작성한다.
		doGet(request, response);
	}

}
