<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	session.setAttribute("idKey", id);
	//세션에 상태유지를 위한 값을 설정한다.
	
	session.setMaxInactiveInterval(15);
	//세션의 유효시간을 초단위로 설정한다.
	//기본값은 30분이다
	
%>
<h1>Session Example1</h1>
<form method="post" action="session1_1.jsp">
	1.가장 좋아하는 계절은?<br>
	<input type="radio" value="봄" name="season">봄
	<input type="radio" value="여름" name="season">여름
	<input type="radio" value="가을" name="season">가을
	<input type="radio" value="겨울" name="season">겨울
	<br>
	
	2. 가장 좋아하는 과일은?<br>
	<input type="radio" value="수박" name="fruit">수박
	<input type="radio" value="멜론" name="fruit">멜론
	<input type="radio" value="사과" name="fruit">사과
	<input type="radio" value="오렌지" name="fruit">오렌지
	<br>
	<input type="submit" value="결과보기">
	
</form>
</body>
</html>