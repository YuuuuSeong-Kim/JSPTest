package com.api.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Dao {
	public int insertApi(VO vo) {
		int re = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##madang", "madang");
			PreparedStatement stmt = conn.prepareStatement("insert into exam values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, vo.getE_id());
			stmt.setString(2, vo.getQualgbcd());
			stmt.setString(3, vo.getQualgbnm());
			stmt.setInt(4, vo.getSeriescd());
			stmt.setString(5, vo.getSeriesnm());
			stmt.setInt(6, vo.getJmcd());
			stmt.setString(7, vo.getJmfldnm());
			stmt.setInt(8, vo.getY_id());
			stmt.setInt(9, vo.getMdobligfldcd());
			stmt.setString(10, vo.getObligfldnm());
			stmt.setInt(11, vo.getMdobligfldcd());
			stmt.setString(12, vo.getMdobligfldnm());
			stmt.setString(13, vo.getDetail());
			
			re = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return re;
	}
}
