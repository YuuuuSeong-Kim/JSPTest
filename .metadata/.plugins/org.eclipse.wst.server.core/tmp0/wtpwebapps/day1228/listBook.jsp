<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	ArrayList<BookVO> list = (ArrayList<BookVO>)request.getAttribute("list");
%>
</head>
<body>
<h2>도서 목록</h2>
<hr>
	<table border="1px" width="80%">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
		</tr>
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.bookid}</td>
				<td><a href="detailBook.do?bookid=${b.bookid }">${b.bookname}</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="insertBook.do">도서 등록</a>
</body>
</html>