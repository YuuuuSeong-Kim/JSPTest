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
	<h2>회원가입</h2>
	<hr>
	<form 
		action="joinMemberOK.do" 
		method="post">
		<table width="80%">
			<tr>
				<td>ID : </td>
				<td>
					<input type="text" name="id" required="required">
				</td>
			</tr>
			<tr>
				<td width="5%">비밀번호 : </td>
				<td>
					<input type="password" name="pwd" required="required">
				</td>
				</tr>
				<tr>
				<td>이름 : </td>
				<td>
					<input type="text" name="name" required="required">
				</td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td>
					<input type="text" name="email" required="required">
				</td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td>
					<input type="text" name="phone" required="required">
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