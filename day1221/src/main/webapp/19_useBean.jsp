<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bvo" class="com.sist.vo.BookVO"/> <!-- BookVO bvo = new BookVO(); 와 동일-->
<jsp:useBean id="bdao" class="com.sist.dao.BookDAO"/>

<jsp:setProperty property="bookid" name="bvo" value="100"/><!--property : 속성, name : 위에 선언한 변수명, value : 값-->
<jsp:setProperty property="bookname" name="bvo" value="재미있는 자바"/>
<jsp:setProperty property="price" name="bvo" value="30000"/>
<jsp:setProperty property="publisher" name="bvo" value="쌍용미디어"/>

도서번호 : <jsp:getProperty property="bookid" name="bvo"/><br>
도서명 : <jsp:getProperty property="bookname" name="bvo"/><br>
가격 : <jsp:getProperty property="price" name="bvo"/><br>
출판사 : <jsp:getProperty property="publisher" name="bvo"/>
<%
	bdao.insertBook(bvo);
%>
</body>
</html>