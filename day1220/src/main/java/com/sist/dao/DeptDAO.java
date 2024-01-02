package com.sist.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.DeptVO;

public class DeptDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String username = "c##madang";
	String password = "madang";
	
	public ArrayList<DeptVO> listDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		String sql = "select * from dept order by dno";
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int dno = rs.getInt(1);
				String dname = rs.getString(2);
				String dloc = rs.getString(3);
				DeptVO vo = new DeptVO(dno, dname, dloc);
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("예외발생 : "+e.getMessage());
		}
		return list;
	}
	
	public DeptVO findByDno(int dno) {
		DeptVO vo = null;
		String sql = "select * from dept where dno="+dno;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				vo = new DeptVO(rs.getInt(1),rs.getString(2),rs.getString(3));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("예외발생 "+e.getMessage());
		}
		return vo;
	}
}
