package com.sist.action;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.EmpDAO;

public class AllEmpAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = null;
		String category = null;
		
		if(request.getParameter("keyword")!=null) {
			category = request.getParameter("category");
			if(category.equals("e.hiredate")) {
				keyword = request.getParameter("keyword");
			}else {
				keyword = "%"+request.getParameter("keyword")+"%";
			}
		}
		String op = request.getParameter("op");
		EmpDAO dao = EmpDAO.getInstance();
		ArrayList<HashMap<String, Object>> list = dao.findEmpAll(category,keyword,op);
		request.setAttribute("list", list);
		return "AllEmp.jsp";
	}

}
