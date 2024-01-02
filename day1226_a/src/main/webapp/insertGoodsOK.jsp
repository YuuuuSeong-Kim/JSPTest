<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
<%
	//파일이 업로드할 실제경로를 알아온다.
	String path = request.getRealPath("upload");

	request.setCharacterEncoding("UTF-8");
	
	MultipartRequest multi = new MultipartRequest(request,path,1024*1024*5,"UTF-8",new DefaultFileRenamePolicy());
	//multi는 사용자가 입력한거를 받아오게함
	//ip같이 입력한게 아닌 정보는 그대로 request로 받아와야함
	
	GoodsVO g = new GoodsVO();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setName(multi.getParameter("name"));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setFname(multi.getOriginalFileName("uploadFile"));
	
	GoodsDAO dao = new GoodsDAO();
	int re = dao.insertGoods(g);
	if(re==1){
		out.print("상품 등록 성공");
	}else{
		out.print("상품 등록 실패");
	}
%>

<hr>
<a href="insertGoods.jsp">상품등록</a><br>
<a href="listGoods.jsp">상품목록</a><br>
</body>
</html>