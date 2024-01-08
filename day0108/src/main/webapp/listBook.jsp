<%@page import="com.sist.vo.BookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		$("#s_pub").css("display","none");
		$.ajax({
			url:"listPublisher.do",
			success:function(data){
				$.each(data,function(){
					var select = $("#s_pub");
					select.append($("<option></option>").html(this).attr("value",this));
					console.log($(this));
				})
			}
		})
		
		$("#category").change(function(){
			if($(this).val()=="price"){
				$("#op").css("display","inline-block");
			}else{
				$("#op").css("display","none");
			}
			
			if($(this).val()=="publisher"){
				$("#s_pub").css("display","inline-block");
				$("#keyword").css("display","none");
				$("#s_pub").attr("name","keyword");
				$("#keyword").removeAttr("name");
				
			}else{
				$("#s_pub").css("display","none");
				$("#keyword").css("display","inline-block");
				$("#s_pub").removeAttr("name");
				$("#keyword").attr("name","keyword");
			}
		})
		
		$("th").on("click",function(){
			console.log($(this).html());
		})
	})
</script>
<style>
	#op{
		display : none;
	}
</style>
</head>
<body>
	<h2>도서목록</h2>
	<hr>
	<form action="listBook.do">
		<select name="category" id="category">
			<option value="bookname">도서명</option>
			<option value="publisher">출판사</option>
			<option value="price" id="price">가격</option>
		</select>
		<select name="op" id="op">
			<option value=">">></option>
			<option value="<"><</option>
			<option value=">=">>=</option>
			<option value="<="><=</option>
			<option value="=">=</option>
		</select>
		 : <select id="s_pub"></select><input type="search" name="keyword" id="keyword"/>
		<input type="submit" value="검색">
	</form>
	<br>
	<table border="solid 1px">
		<tr>
			<c:if test="${category != null}">
			<th><a href="listBook.do?order=bookid&keyword=${keyword }&category=${category}&op=${op}&snum=${snum}">도서번호</a></th>
			<th><a href="listBook.do?order=bookname&keyword=${keyword }&category=${category}&op=${op}&snum=${snum}">도서명</a></th>
			<th><a href="listBook.do?order=price&keyword=${keyword }&category=${category}&op=${op}&snum=${snum}">가격</a></th>
			<th><a href="listBook.do?order=publisher&keyword=${keyword }&category=${category}&op=${op}&snum=${snum}">출판사</a></th>
			</c:if>
			<c:if test="${category == null}">
			<th><a href="listBook.do?order=bookid&snum=${snum}">도서번호</a></th>
			<th><a href="listBook.do?order=bookname&snum=${snum}">도서명</a></th>
			<th><a href="listBook.do?order=price&snum=${snum}">가격</a></th>
			<th><a href="listBook.do?order=publisher&snum=${snum}">출판사</a></th>
			</c:if>
		</tr>
		<c:forEach var="i" items="${list }">
			<tr>
				<td>${i.bookid }</td>
				<td>${i.bookname }</td>
				<td>${i.price }</td>
				<td>${i.publisher }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>