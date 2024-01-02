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
		String msg = request.getParameter("msg");
		int num = Integer.parseInt(request.getParameter("number"));
		StringBuilder sb = new StringBuilder();
		while(num!=0){
			sb.append(msg).append("<br>");
			num--;
		}
		out.print(sb);
	%>
</body>
</html>