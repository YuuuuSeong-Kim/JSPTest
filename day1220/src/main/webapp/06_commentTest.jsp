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
		//문자열변수 name을 선언한다.
		String name = "korea";
		int year = 2024;
		String title = "hello";
	%>
	
	<!-- 이것은 html 주석이다 -->
	<%--
		요것은 jsp 주석이다. 소스보기에 노출되지 않는다.
	 --%>
	 
	 <%=name /* name 변수의 내용을 출력한다.*/ %>
	 
	 <%= year %>
	 <%-- <%= year %> --%>
	 <!--<%=title %>-->
	 <!-- <h2>Hello<h2> -->
</body>
</html>