package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.sist.db.ConnectionProvider;
import com.sist.vo.BookVO;

public class BookDAO {
	public ArrayList<BookVO> findAll(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		String sql = "select * from book";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BookVO vo = new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
				list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return list;
	}
	
	public int insertBook(BookVO vo) {
		int re = 0;
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBookid());
			pstmt.setString(2, vo.getBookname());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getPublisher());
			pstmt.setString(5, vo.getFname());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int updateBook(BookVO vo) {
		int re =0;
		String sql = "update book set bookname=?, price=?, publisher=?,fname=? where bookid=?";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBookname());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setString(4, vo.getFname());
			pstmt.setInt(5, vo.getBookid());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int deleteBook(int bookid) {
		int re = 0;
		String sql = "delete book where bookid="+bookid;
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
			ConnectionProvider.close(conn, stmt);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public BookVO detailBook(int bookid) {
		BookVO vo = null;
		String sql = "select * from book where bookid="+bookid;
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo = new BookVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return vo;
	}
	
	public int getNextBookid() {
		int bookid = 0;
		String sql = "select nvl(max(bookid),0)+1 from book";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				bookid = rs.getInt(1);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return bookid;
	}
}
