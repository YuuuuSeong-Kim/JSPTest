package com.sist.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	
	public int insertGoods(GoodsVO g) {
		int re = -1;
		String sql = "insert into goods values(?,?,?,?,?)";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,g.getNo());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3,g.getPrice());
			pstmt.setInt(4,g.getQty());
			pstmt.setString(5, g.getFname());
			re = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
	
	public ArrayList<GoodsVO> findAll(){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from goods";
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				int qty = rs.getInt(4);
				String fname = rs.getString(5);
				
				GoodsVO gvo = new GoodsVO(no, name, price, qty, fname);
				list.add(gvo);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		
		return list;
	}
}
