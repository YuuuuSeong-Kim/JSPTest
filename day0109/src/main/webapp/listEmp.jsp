<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		$("#e_job").css("display","none");
		$("#submit").attr("disabled",true);
		var arr;
		
		$("#category").change(function(){
			
			if($("#category").val()=="none"){
				$("#submit").attr("disabled",true);
			}else{
				$("#submit").attr("disabled",false);
			}
			
			if($(this).val()=="job"){
				$.ajax({
					url: "listJob.do",
					success : function(data){
						arr=data;
						addJob(arr);
					}
				})
				
			}else if($(this).val()=="dno"){
				$.ajax({
					url: "listDno.do",
					success : function(data){
						arr=data;
						addJob(arr);
					}
				})
			}
			
			if($(this).val()=="job"||$(this).val()=="dno"){
				$("#keyword").css("display","none");
				$("#keyword").removeAttr("name");
				$("#e_job").css("display","inline-block");
			}else{
				$("#e_job").css("display","none");
				$("#e_job").removeAttr("name");
				$("#keyword").css("display","inline-block");
			}
		})
		
		function addJob(arr){
			$("#e_job").empty();
			$.each(arr, function(){
				var select = $("#e_job");
				select.append($("<option></option>").html(this).attr("value",this));
			})
		}
	})
</script>
</head>
<body>
<h2>사원 목록</h2>
<hr>
<form>
	<select name="category" id="category">
		<option selected="selected" value="none">카테고리</option>
		<option value="jumin">주민번호</option>
		<option value="email">이메일</option>
		<option value="job">직책</option>
		<option value="dno">부서번호</option>
	</select>
	<select name="keyword" id="e_job">
	
	</select>
	<input type="search" name="keyword" id="keyword"/>
	<input type="submit" value="검색" id="submit">
</form>
<hr>
<table border="solid 1px">
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>직책</th>
		<th>입사일</th>
		<th>급여</th>
		<th>부서번호</th>
		<th>주민번호</th>
		<th>이메일</th>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>		
			<td>${e.ename }</td>		
			<td>${e.job }</td>		
			<td>${e.hiredate }</td>		
			<td>${e.salary }</td>		
			<td>${e.dno }</td>		
			<td>${e.jumin }</td>		
			<td>${e.email }</td>		
		</tr>
	</c:forEach>
</table>
</body>
</html>