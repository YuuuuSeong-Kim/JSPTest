<%@page import="java.io.File"%>
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
<%
	String path = request.getRealPath("upload");
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDAO dao = new GoodsDAO();
	String fname = dao.findByNo(no).getFname();
	File file = new File(path+"/"+fname);
	file.delete();
	int re = dao.deleteGoods(no);
	if(re==1){
		out.print("삭제 완료");
	}else{
		out.print("삭제 실패");
	}
%>
<br>
<a href="listGoods.jsp">상품 목록</a>
</body>
</html>