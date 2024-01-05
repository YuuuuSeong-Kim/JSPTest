package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.db.ConnectionProvider;
import com.sist.vo.GoodsVO;

public class GoodsDAO {
	int pageSize = 3;
	int totalPage = 0;
	int totalRecord = 0;
	
	public int getTotalRecord(String name) {
		String sql = "select count(*) from goods";
		if(name != null) {
			sql +=  " where name like '%"+name+"%'";
		}
		try {
			Context context
			= new InitialContext();
			DataSource ds =
			(DataSource) context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				totalRecord = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return totalRecord;
	}
	
	public int getTotalPage(String name) {
		int totalRecord = getTotalRecord(name);
		totalPage = totalRecord/pageSize;
		if(totalRecord%pageSize!=0) {
			totalPage++;
		}
		return totalPage;
	}
	
	public ArrayList<GoodsVO> findAll(int pageNum, String name){
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		String sql = "select * from (select goods.*, rownum rnum from goods ";
			if(name!=null) {
				sql += "where name like '%"+name+"%'";
			}
				
			sql	+= ") g where g.rnum between ? and ?";
			System.out.println(sql);
		pageNum *= pageSize;
		try {
			Context context
			= new InitialContext();
			DataSource ds =
			(DataSource) context.lookup("java:/comp/env/myoracle");
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, pageNum-2);
			stmt.setInt(2, pageNum);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				list.add(new GoodsVO(rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3), 
						rs.getInt(4), 
						rs.getString(5)));
			}			
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return list;
	}
}















