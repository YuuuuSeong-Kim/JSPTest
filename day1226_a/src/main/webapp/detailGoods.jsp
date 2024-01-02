<%@page import="com.sist.vo.GoodsVO"%>
<%@page import="com.sist.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkDelete(no){
		re = confirm("정말로 삭제하시겠습니까?");
		if(re==true){
			location.href = "deleteGoods.jsp?no="+no;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<h2>상품상세</h2>
	<hr>
	<%
	GoodsDAO dao = new GoodsDAO();
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsVO vo = dao.findByNo(no);
	%>
	
	<table width="60%" border="1">
		<tr>
			<th>상품번호</th>
			<th>상품이름</th>
			<th>상품가격</th>
			<th>상품수량</th>
			<th>상품사진</th>
		</tr>
		<tr>
			<td><%=vo.getNo()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getPrice()%></td>
			<td><%=vo.getQty()%></td>
			<td><img src="./upload/<%=vo.getFname()%>" width="70px"
				height="70px"></td>
		</tr>
	</table>
	<hr>
	<!-- <a href="deleteGoods.jsp?no=<%=no%>&fname=<%=vo.getFname()%>">삭제</a> -->
	<a href="#" onclick="checkDelete(<%=no%>)">삭제</a>
	<a href="updateGoods.jsp?no=<%=vo.getNo()%>">수정</a>
	<a href="listGoods.jsp">상품목록</a><br>
</body>
</html>