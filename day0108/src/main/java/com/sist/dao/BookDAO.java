package com.sist.dao;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {

	static BookDAO dao = null;

	private BookDAO() {

	}

	public static BookDAO getInstance() {
		if (dao == null) {
			dao = new BookDAO();
		}
		return dao;
	}

	public ArrayList<String> findPublisher(){
		ArrayList<String> publisher = new ArrayList<String>();
		String sql = "select distinct publisher from book";
		try {
			Connection conn = ConnectionProvider.getconnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				publisher.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findPublisher 예외발생 : "+e.getMessage());
		}
		return publisher;
	}
	
	public ArrayList<BookVO> findAll(String keyword, String category, String op,String order, String ascORdesc) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		if (category != null) {
			if (op!=null) {
				sql += " where " + category + " " + op + " " + keyword;
			} else {
				sql += " where " + category + " like '%" + keyword + "%'";
			}
		}
		
		if(order != null) {
			sql += " order by "+order+" "+ascORdesc;
		}
		System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getconnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findAll 예외발생 : " + e.getMessage());
		}
		return list;
	}
}
