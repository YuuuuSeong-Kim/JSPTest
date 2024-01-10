<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#op{
	display: none;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		function popupOpen(){	var popUrl = "testbox.jsp";
		var popOption = "width=370, height=360, resizable=no, scrollbars=no, status=no;"; 
		window.open(popUrl,"",popOption);
			}
		
		popupOpen();
		$("#cname").change(function(){
			var v = $(this).val();
			if(v == "price"){
				$("#op").css("display","inline-block");
			}else{
				$("#op").css("display","none");
			}
		});
	});
</script>
</head>
<body>
<h2>도서목록</h2>
<hr>

<form action="listBook.do" method="post">
	<select name="cname" id="cname">
		<option value="bookname">도서명</option>
		<option value="publisher">출판사명</option>
		<option value="price">가격</option>
	</select>	
	<select name="op" id="op">
		<option value=">">></option>
		<option value="<"><</option>
		<option value=">=">>=</option>
		<option value="<="><=</option>
		<option value="=">=</option>
	</select>	
	<input type="search" name="keyword">
	<input type="submit" value="검색">
</form>

<table>
	<tr>
		<th><a href="listBook.do?sname=bookid">도서번호</a></th>
		<th><a href="listBook.do?sname=bookname">도서명</a></th>
		<th><a href="listBook.do?sname=price">가격</a></th>
		<th><a href="listBook.do?sname=publisher">출판사</a></th>
	</tr>
	
	<c:forEach var="b" items="${list }">
		<tr>
			<td>${b.bookid }</td>
			<td>${b.bookname }</td>
			<td>${b.price }</td>
			<td>${b.publisher }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>


















