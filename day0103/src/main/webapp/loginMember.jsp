<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		position: absolute;
  		top: 45%;
  		left: 45%;
	}
</style>
</head>
<body>
<form method="post" action="loginMemberOK.do">
	<table>
		<tr>
			<td>ID :</td>
			<td><input type="text" name="id" required="required"></td>
		</tr>
		<tr>
			<td>PWD :</td>
			<td><input type="password" name="pwd" required="required"></td>
		</tr>
		
		<tr>
				<td colspan="2">
					<input type="submit" value="로그인">&nbsp;
					<a href="joinMember.do">회원가입</a>
				</td>
			</tr>
	</table>
</form>
</body>
</html>