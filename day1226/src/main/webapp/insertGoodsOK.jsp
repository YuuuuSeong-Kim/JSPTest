<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="g" class="com.sist.vo.GoodsVO"/>
<jsp:useBean id="dao" class="com.sist.dao.GoodsDAO"/>
<jsp:setProperty property="*" name="g"/>
<%

	int re = dao.insertGoods(g);
	String result="등록 실패";
	if(re!=-1){
		result = "등록 성공";
	}
%>
<%=result %><br>
<a href="insertGoods.jsp">상품등록</a><br>
<a href="listGoods.jsp">상품목록</a><br>
</body>
</html>