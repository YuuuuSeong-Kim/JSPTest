package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.sist.dao.EmpDAO;

public class ListMnameAction implements SistAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = EmpDAO.getInstance();
		Gson gson = new Gson();
		String ListMname = gson.toJson(dao.getMname());
		request.setAttribute("ListMname", ListMname);
		return "listMname.jsp";
	}

}
