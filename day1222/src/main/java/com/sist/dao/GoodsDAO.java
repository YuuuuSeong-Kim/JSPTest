package com.sist.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.GoodsVO;

public class GoodsDAO {
	String dirver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "c##madang";
	String password = "madang";
	
	public ArrayList<GoodsVO> listGoods(){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try {
			Class.forName(dirver);
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
			String sql = "select * from goods";
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
