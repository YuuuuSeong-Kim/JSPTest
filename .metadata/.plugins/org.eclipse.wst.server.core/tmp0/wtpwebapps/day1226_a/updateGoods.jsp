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
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsDAO dao = new GoodsDAO();
	GoodsVO g = dao.findByNo(no);
%>
	<h2>상품수정</h2>
	<hr>
	<form 
		action="updateGoodsOK.jsp" 
		method="post"
		enctype="multipart/form-data">
		<!-- enctype을 multipart/form-data로 하면 입력한 값들이 인코딩이 되지 않아 인코딩이 필요한 값들은 request를 못 쓴다(ip같은건 가능) -->
		<table width="80%">
			<tr>
				<td width="20%">상품번호</td>
				<td width="70%">
					<input type="hidden" name="no" value="<%=g.getNo()%>">
					<%=g.getNo()%>
				</td>
			</tr>
			
			<tr>
				<td>상품이름</td>
				<td>
					<input type="text" name="name" required="required" value="<%=g.getName()%>">
				</td>
			</tr>
			<tr>
				<td>상품수량</td>
				<td>
					<input type="text" name="qty" required="required" value="<%=g.getQty()%>">
				</td>
			</tr>
			<tr>
				<td>상품가격</td>
				<td>
					<input type="text" name="price" required="required" value="<%=g.getPrice()%>">
				</td>
			</tr>
			<tr>
				<td>상품파일</td>
				<td>
					<input type="hidden" name="fname" value="<%=g.getFname()%>">
					<img src="./upload/<%=g.getFname()%>" width="50" height="50">
					<input type="file" name="uploadFile">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>