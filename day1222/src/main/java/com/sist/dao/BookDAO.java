package com.sist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BookVO;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";
	
	public ArrayList<BookVO> listBook(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book order by bookid";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int bookid = rs.getInt(1);
				String bookname = rs.getString(2);
				int price = rs.getInt(3);
				String publisher = rs.getString(4);
				BookVO vo = new BookVO(bookid, bookname, price, publisher);
				list.add(vo);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return list;
	}
	
	public int nextBook() {
		int bookid = 0;
		String sql = "select bookid from book order by bookid desc";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				bookid = rs.getInt(1)+1;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return bookid;
	}
	
	public int insertBook(BookVO vo) {
		int re = 0;
		String sql = "insert into book values("+
						vo.getBookid()+",'"+
						vo.getBookname()+"',"+
						vo.getPrice()+",'"+
						vo.getPublisher()+"')";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int updateBook(int bookid, String bookname, int price, String publisher) {
		int re = 0;
		String sql = "update book set bookname='"+bookname
				+"', price="+price+", publisher='"+publisher+"' where bookid="+bookid;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int deleteBook(int bookid) {
		int re = 0;
		String sql = "delete from book where bookid="+bookid;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
}
