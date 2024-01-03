<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 위의 taglib은 자바 문법을 대신 써주는 태그를 불러온다 core는 대체로 c라고 해서 prefix에 c라고 했다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
%>
<h2>${id }님 환영합니다.</h2>
<h2>게시물 목록</h2>
<hr>
<table border="1" width="80%">
	<tr>
		<th width="10%">글번호</th>
		<th width="80%">글제목</th>
		<th width="10%">작성자</th>
	</tr>
	<%--  변수를 불러올 떈 ${} 로 불러온다 --%>
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td><a href="detailBoard.do?no=${b.no}">${b.title}</a></td>
			<td>${b.writer}</td>
		</tr>
	</c:forEach>
</table>
<a href="insertBoard.do">게시글 등록</a><br>
<a href="../logoutMember.do">로그아웃</a>
</body>
</html>