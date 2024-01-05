package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;

public class ListGoodsAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDAO dao = new GoodsDAO();
		int pageNum = 1;
		String name = null;
		if(request.getParameter("name")!=null) {
			name = request.getParameter("name");
		}
		if(request.getParameter("pageNum")!=null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		int totalPage = dao.getTotalPage(name);
		if(pageNum>totalPage) {
			pageNum=totalPage;
		}
		
		request.setAttribute("list", dao.findAll(pageNum,name));
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("name", name);
		return "listGoods.jsp";
	}

}
