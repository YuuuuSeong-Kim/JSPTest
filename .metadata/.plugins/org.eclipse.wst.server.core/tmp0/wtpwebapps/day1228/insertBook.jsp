<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	int b = (int)request.getAttribute("b");
%>
</head>
<body>
<h2>도서등록</h2>
<hr>
<form action="insertBook.do" method="post" enctype="multipart/form-data">
<table>
	<tr>
	<td>도서번호 : </td><td>${b}<input type="hidden" name="bookid" value="${b}"></td>
	</tr>
	<tr>
	<td>도서명 : </td><td><input type="text" name="bookname" required="required"/></td>
	</tr>
	<tr>
	<td>가격 : </td><td><input type="number" name="price" required="required"/></td>
	</tr>
	<tr>
	<td>출판사명 : </td><td><input type="text" name="publisher" required="required"/></td>
	</tr>
	<tr>
	<td>이미지 : </td><td><input type="file" name="uploadFile" required="required"/></td>
	</tr>
	</table>
	<input type="submit" value="등록">
	<input type="reset" value="다시 입력"><br>
	<a href="listBook.do">도서 목록</a>
</form>
</body>
</html>