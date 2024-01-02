<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkDelete(bookid){
		re = confirm("정말 삭제하시겠습니까?");
		if(re){
			location.href = "deleteBook.do?bookid="+bookid;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
<h2>도서 상세</h2>
<hr>
	도서번호 : ${vo.bookid }<br>
	도서명 : ${vo.bookname }<br>
	가격 : ${vo.price }<br>
	출판사 : ${vo.publisher }<br>
	사진 : <img src="./data/${vo.fname }" width="50px" height="50px"> <br>
	<hr>
	<a href="updateBook.do?bookid=${vo.bookid }">수정</a>
	<a href="#" onclick="checkDelete(${vo.bookid})">삭제</a><br>
	<hr>
	<a href="listBook.do">도서 목록</a>
</body>
</html>