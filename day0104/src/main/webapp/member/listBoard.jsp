<%@page import="java.io.Console"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 위의 taglib은 자바 문법을 대신 써주는 태그를 불러온다 core는 대체로 c라고 해서 prefix에 c라고 했다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"/>
<script type="text/javascript">
$(function(){
	$(document).on("click","div",function(){
		$("div").css("background","red");
	})
})
</script>
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
%>

<h2>게시물 목록</h2>
<hr>
<table border="1" width="80%">
	<tr>
		<th width="10%">글번호</th>
		<th width="80%">글제목</th>
		<th width="10%">작성자</th>
	</tr>
	<%--  변수를 불러올 떈 ${} 로 불러온다 --%>
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td>			
				<c:if test="${b.b_level > 0}">
					<c:forEach var="i" begin="1" end="${b.b_level }">
						&nbsp;&nbsp;
					</c:forEach>
					<img src="re.png">
				</c:if>
				<a href="detailBoard.do?no=${b.no}">${b.title}</a>
			</td>
			<td>${b.writer}</td>
		</tr>
	</c:forEach>
</table>
<c:forEach var="i" begin="1" end="${totalPage }">
	&nbsp;<a href="listBoard.do?pageNum=${i }" ><div class="pageNation">${i }</div></a>&nbsp;
</c:forEach><br>
<a href="insertBoard.do">게시글 등록</a>
</body>
</html>