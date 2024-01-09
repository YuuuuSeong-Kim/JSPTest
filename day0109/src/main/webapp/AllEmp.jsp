<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="solid 1px">
	<tr>
		<th>사원번호</th>
		<th>사원명</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>급여</th>
		<th>수당</th>
		<th>실수령액</th>
		<th>입사일</th>
		<th>근무개월수</th>
		<th>관리자명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>직책</th>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>
			<td>${e.ename }</td>
			<td>${e.dno }</td>
			<td>${e.dname }</td>
			<td>${e.salary }</td>
			<td>${e.sudang }</td>
			<td>${e.realmoney }</td>
			<td>${e.hiredate }</td>
			<td>${e.month }</td>
			<td>${e.mname }</td>
			<td>${e.jumin }</td>
			<td>${e.email }</td>
			<td>${e.job }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>