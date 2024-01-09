package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.sist.db.ConnectionProvider;
import com.sist.vo.EmpVO;

public class EmpDAO {
	
	static EmpDAO dao = null;
	
	private EmpDAO() {
	}
	
	public static EmpDAO getInstance() {
		if(dao==null) {
			dao = new EmpDAO();
		}
		return dao;
	}
	
	public ArrayList<HashMap<String, Object>> findEmpAll(){
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		String sql = "SELECT e.eno, "
					+ "e.ename, "
					+ "e.dno,"
					+ " d.dname,"
					+ " e.salary,"
					+ " (e.salary/10) sudang,"
					+ " (e.salary+(e.salary/10)) realmoney,"
					+ " to_char( e.hiredate,'YYYY-MM-DD'),"
					+ " TRUNC(MONTHS_BETWEEN(SYSDATE, e.hiredate)), "
					+ "m.ename, "
					+ "rpad(substr(e.jumin,1,8),14,'*') jumin, "
					+ "e.email, "
					+ "e.job "
					+ "FROM EMP e , EMP m, DEPT d WHERE e.mgr=m.eno AND e.dno=d.dno"
					+ " order by e.eno";
		System.out.println(sql);
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("eno", rs.getObject(1));
				map.put("ename", rs.getObject(2));
				map.put("dno", rs.getObject(3));
				map.put("dname", rs.getObject(4));
				map.put("salary", rs.getObject(5));
				map.put("sudang", rs.getObject(6));
				map.put("realmoney", rs.getObject(7));
				map.put("hiredate", rs.getObject(8));
				map.put("month", rs.getObject(9));
				map.put("mname", rs.getObject(10));
				map.put("jumin", rs.getObject(11));
				map.put("email", rs.getObject(12));
				map.put("job", rs.getObject(13));
				list.add(map);
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findEmpAll 예외발생 : "+e.getMessage());
		}
		return list;
	}
	
	public ArrayList<String> findJobList(){
		ArrayList<String> jobList = new ArrayList<String>();
		String sql = "select distinct job from emp";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jobList.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findJobList 예외발생 : "+e.getMessage());
		}
		return jobList;
	}
	
	public ArrayList<String> findDnoList(){
		ArrayList<String> jobList = new ArrayList<String>();
		String sql = "select distinct dno from emp";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				jobList.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findDnoList 예외발생 : "+e.getMessage());
		}
		return jobList;
	}
	
	public ArrayList<EmpVO> findAll(String category, String keyword){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		String sql = "SELECT ENO,ENAME,JOB, HIREDATE, SALARY, DNO, MGR, COMM, rpad(substr(jumin,1,8),14,'*') jumin , EMAIL FROM emp";
		if(category!=null) {
			sql += " where "+category+" like '"+keyword+"'";
		}
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				list.add(new EmpVO(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDate(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getInt(8),
						rs.getString(9),
						rs.getString(10)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println("findAll 예외발생 : "+e.getMessage());
		}
		return list;
	}
}
