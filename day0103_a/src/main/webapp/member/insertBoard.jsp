<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.sist.vo.BoardVO"%>
<%@page import="com.sist.dao.BoardDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<hr>
	<form 
		action="insertBoardOK.do" 
		method="post"
		enctype="multipart/form-data">
		<table width="80%">
			<tr>
				<td>작성자 : </td>
				<td>
					<input type="text" name="writer" disabled="disabled" value="${userID }">
				</td>
			</tr>
			<tr>
				<td width="5%">글 제목 : </td>
				<td width="5%">
					<input type="text" name="title" required="required">
				</td>
				<td width="5%">비밀번호 : </td>
				<td>
					<input type="password" name="pwd" required="required">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea cols="60" rows="10" name="content" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td>사진</td>
				<td>
					<input type="file" name="uploadFile" required="required">
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">&nbsp;
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>