package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;

public class OrdersDAO {
	private static OrdersDAO dao;
	
	private OrdersDAO() {
	}
	
	public static OrdersDAO getinstance() {
		if(dao==null) {
		 dao = new OrdersDAO();
		}
		return dao;
	}

	public ArrayList<HashMap<String, Object>> listOrders(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT c.custid, c.name, b.bookname FROM CUSTOMER c , ORDERS o , BOOK b WHERE c.CUSTID = o.CUSTID AND o.BOOKID = b.BOOKID";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("custid", rs.getObject(1));
				map.put("name", rs.getObject(2));
				map.put("bookname", rs.getObject(3));
				list.add(map);
			}
		} catch (Exception e) {
			System.out.println("listOrders 예외 발생 :"+e.getMessage());
		}
		return list;
	}
}
