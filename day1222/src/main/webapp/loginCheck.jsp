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
	String id = (String)session.getAttribute("idKey");
	if(id==null){
		response.sendRedirect("login.html");
	}
	
	String userID =(String)session.getAttribute("idKey");
%>
<%=userID%>님 로그인 하였습니다.

<a href="logOut.jsp">로그아웃</a>
<hr>
</body>
</html>