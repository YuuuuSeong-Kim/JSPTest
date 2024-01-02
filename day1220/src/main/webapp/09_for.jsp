<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>For Example</h1>
1에서 10까지 합은?<br>
<%
	int i, sum = 0;
	for(i=1; i<=10; i++){
		sum += i;
		if(i==10){
		out.print(i+"=");
			break;
		}
		out.print(i+"+");
	}
%>
<%=sum %>
</body>
</html>