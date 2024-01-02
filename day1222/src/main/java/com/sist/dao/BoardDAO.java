package com.sist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.BoardVO;
import com.sist.vo.BoardVO;

public class BoardDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";
	
	public ArrayList<BoardVO> listBoard(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from Board order by no";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6));
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
	
	public int nextBoard() {
		int no = 0;
		String sql = "select no from Board order by no desc";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				no = rs.getInt(1)+1;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return no;
	}
	
	public int insertBoard(BoardVO vo) {
		int re = 0;
		String sql = "insert into Board values(seq_board.nextval,?,?,?,sysdate,?)";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int updateBoard(BoardVO vo) {
		int re = 0;
		String sql = "update Board set TITLE=?, WRITER=?, CONTENT=?, REGDATE=sysdate, IP=?"
				+ "where no=?";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getIp());
			re = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public int deleteBoard(int no) {
		int re = 0;
		String sql = "delete from Board where no="+no;
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
