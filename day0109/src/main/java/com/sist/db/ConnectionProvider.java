package com.sist.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/sist");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("getConnection 예외발생 : "+e.getMessage());
		}
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void close(Connection conn, Statement stmt,ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
