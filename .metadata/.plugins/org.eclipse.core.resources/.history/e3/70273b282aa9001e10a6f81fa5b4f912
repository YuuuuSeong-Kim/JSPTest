package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.BoardVO;

public class BoardDAO {
	
	public int update(BoardVO b) {
		int re = -1;
		String sql = "update board set title=?,content=?, fname=? where no=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setString(3, b.getFname());
			pstmt.setInt(4, b.getNo());
			pstmt.setString(5, b.getPwd());
			re = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public int deleteBoard(int no,String pwd) {
		int re=-1;
		String sql="delete board where no="+no+"and pwd="+pwd;
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			re = stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public BoardVO detail(int no) {
		BoardVO vo = new BoardVO();
		String sql = "select * from board where no="+no;
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vo.setNo(no);
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPwd(rs.getString(4));
				vo.setContent(rs.getString(5));
				vo.setRegdate(rs.getDate(6));
				vo.setHit(rs.getInt(7));
				vo.setFname(rs.getString(8));
				vo.setIp(rs.getString(9));
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return vo;
	}
	
	public int insert(BoardVO b) {
		String sql = "insert into board values(?,?,?,?,?,sysdate,1,?,?)";
		int re = -1;
		try {
			Connection conn = ConnectionProvider.getconConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setString(6, b.getFname());
			pstmt.setString(7, b.getIp());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<BoardVO> findAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from board";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO vo = new BoardVO(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getString(9)
						);
				list.add(vo);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}

	public int getNextNO() {
		int no = 0;
		String sql = "select nvl(max(no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getconConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return no;
	}
}
