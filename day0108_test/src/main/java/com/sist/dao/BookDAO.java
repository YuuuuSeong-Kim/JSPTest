package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

import oracle.net.aso.c;

public class BookDAO {
	
	public static BookDAO dao = null;
	
	private BookDAO() {		
	}
	
	public static BookDAO  getInstance() {
		if(dao == null) {
			dao = new BookDAO();
		}
		return dao;
	}
	
	
	public ArrayList<BookVO> findAll(String keyword, 
			String cname, 
			String op, 
			String sname){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		if(keyword != null) {
			if(cname.equals("price")) {
				sql += " where price "+op+" "+ keyword;
			}else {
				sql += " where "+cname+" like '%"+keyword+"%'";
			}
		}
		
		if(sname != null) {
			sql += " order by "+sname;
		}
		
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}
