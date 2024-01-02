<%@page import="com.sist.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	BookVO vo = (BookVO)request.getAttribute("vo");
%>
</head>
<body>
<h2>도서수정</h2>
<hr>
<form action="updateBookOK.do" method="post" enctype="multipart/form-data">
<table>
	<tr>
	<td>도서번호 : </td><td>${vo.bookid}<input type="hidden" name="bookid" value="${vo.bookid}"></td>
	</tr>
	<tr>
	<td>도서명 : </td><td><input type="text" name="bookname" required="required" value="${vo.bookname}"/></td>
	</tr>
	<tr>
	<td>가격 : </td><td><input type="number" name="price" required="required" value="${vo.price}"/></td>
	</tr>
	<tr>
	<td>출판사명 : </td><td><input type="text" name="publisher" required="required" value="${vo.publisher}"/></td>
	</tr>
	<tr>
	<td>이미지 : ${vo.fname}</td><td><input type="file" name="uploadFile"/>
			<input type="hidden" name="oldFname" value="${vo.fname}">
	</td>
	</tr>
	</table>
	<input type="submit" value="수정">
	<input type="reset" value="다시 입력"><br>
	<a href="listBook.do">도서 목록</a>
</form>
</body>
</html>