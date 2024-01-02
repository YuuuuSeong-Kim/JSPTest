<%@page import="com.sist.vo.BoardVO"%>
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
			pwd = prompt("암호를 입력하세요");
			if(pwd==null){
				return false;
			}
			location.href = "deleteBoard?no="+no+"&pwd="+pwd;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<h2>게시글 상세</h2>
	<hr>
	글번호 : ${vo.no }<br>
	글제목 : ${vo.title }<br>
	작성자 : ${vo.writer }<br>
	글내용 : <br><textarea rows="20" cols="60" border="1px">${vo.content }</textarea><br>
	조회수 : ${vo.hit }<br>
	등록일 : ${vo.regdate }<br>
	첨부파일 : ${vo.fname }<br>
	<br>
	<a href="listBoard.do">글목록</a>
	<a href="updateBoard.do?no=${vo.no}">수정</a>
	<a href="deleteBoard.do?no=${vo.no}">삭제</a>
</body>
</html>