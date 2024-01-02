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
	String season = request.getParameter("season");
	String fruit = request.getParameter("fruit");
	
	String id = (String)session.getAttribute("idKey");
	//세션에 저장된 값을 읽어와서 변수에 저장
	
	String sessionId = session.getId();
	//클라이언트(브라우저)가 연결을 하면
	//각 클라이언트를 구별하기 위한 논리적인 연결이 이루어 지는데
	//그것을 세션이라고 하고
	//세션아이디가 할당이 되는데 그 세션아이디를 읽어와서 변수에 저장
	
	int intervalTime = session.getMaxInactiveInterval();
	//세션의 유효시간을 읽어와서 변수에 저장한다.
	
	if(id!=null){
		%>
		<h1>Session Example1</h1>
		<b><%=id %></b>님이 좋아하는 계절과 과일은<br>
		<b><%=season %></b>과 <b><%=fruit %></b>입니다.<br>
		세션 ID : <%=sessionId %><br>
		세션 유지 시간 : <%=intervalTime %><br>
		<%
	}else{
		out.print("<h1 color=\"red\">세션이 만료되었거나 잘못된 경로의 접근입니다.</h1>");
	}
%>
</body>
</html>