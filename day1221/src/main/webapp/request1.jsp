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
	String name = request.getParameter("name");
	int studentNum = Integer.parseInt(request.getParameter("studentNum"));
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");
	if(gender.equals("man")){
		gender="남자";
	}else{
		gender="여자";
	}
	out.print("성명 : "+name+"<br>");
	out.print("학번 : "+studentNum+"<br>");
	out.print("성별 : "+gender+"<br>");
	out.print("전공 : "+major+"<br>");
%>
</body>
</html>