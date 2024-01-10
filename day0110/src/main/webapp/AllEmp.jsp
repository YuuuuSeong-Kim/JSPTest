<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#dname").css("display","none");
		$("#op").css("display","none");
		$("#date_keyword").css("display","none");
		$("#dname").removeAttr("name");
		var deptList;
		var mList;
		var jobList;
		
		$.ajax({
			url:"listDname.do",
			success:function(data){
				deptList=data;
			}
		})
		
		$.ajax({
			url:"listMname.do",
			success:function(data){
				mList=data;
			}
		})
		
		$.ajax({
			url:"listJob.do",
			success:function(data){
				jobList=data;
			}
		})
		
		$("#category").change(function(){
			$("#date_keyword").removeAttr("name");
			if($("#category").val()=="d.dname"||$("#category").val()=="m.ename"||$("#category").val()=="e.job"){
				if($("#category").val()=="d.dname"){
					select(deptList);
				}
				
				if($("#category").val()=="m.ename"){
					select(mList);
				}
				
				if($("#category").val()=="e.job"){
					select(jobList);
				}
				
				$("#keyword").css("display","none");
				$("#keyword").removeAttr("name");
				$("#date_keyword").removeAttr("name");
				$("#dname").attr("name","keyword");
				
				$("#dname").css("display","inline-block");
			}
			else if($("#category").val()=="e.hiredate"){
				$("#op").css("display","inline-block");
				$("#dname").removeAttr("name");
				$("#keyword").removeAttr("name");
				$("#date_keyword").css("display","inline-block");
				$("#date_keyword").attr("name","keyword");
				$("#keyword").css("display","none");
			}
			else{
				$("#dname").css("display","none");
				$("#dname").removeAttr("name");
				$("#date_keyword").removeAttr("name");
				$("#keyword").attr("name","keyword");
				$("#keyword").css("display","inline-block");
			}
		})
		
		function select(data){
			var select = $("#dname");
			select.empty();
			$.each(data,function(){
					select.append($("<option></option>").html(this));
				})
		}
	})
</script>
</head>
<body>
<h2>모든 사원 목록</h2>
<hr>
<form action="AllEmp.do">
	<select id="category" name="category">
		<option value="e.ename">사원이름</option>
		<option value="m.ename">관리자이름</option>
		<option value="d.dname">부서이름</option>
		<option value="e.job">직책</option>
		<option value="e.hiredate">입사일</option>
	</select>
	
	<select id="op" name="op">
		<option value=">">></option>
		<option value=">=">>=</option>
		<option value="<"><</option>
		<option value="<="><=</option>
		<option value="=">=</option>
	</select>
	
	<select id="dname" name="keyword"></select>
	<input type="search" name="keyword" id="keyword">
	<input type="date" id="date_keyword">
	 <input type="submit" value="검색">
</form>
<hr>
<table border="solid 1px">
	<tr>
		<th>사원번호</th>
		<th>사원명</th>
		<th>부서번호</th>
		<th>부서명</th>
		<th>급여</th>
		<th>수당</th>
		<th>실수령액</th>
		<th>입사일</th>
		<th>근무개월수</th>
		<th>관리자명</th>
		<th>주민번호</th>
		<th>이메일</th>
		<th>직책</th>
	</tr>
	<c:forEach var="e" items="${list }">
		<tr>
			<td>${e.eno }</td>
			<td>${e.ename }</td>
			<td>${e.dno }</td>
			<td>${e.dname }</td>
			<td>${e.salary }</td>
			<td>${e.sudang }</td>
			<td>${e.realmoney }</td>
			<td>
				<fmt:formatDate value="${e.hiredate }" pattern="yyyy-MM-dd"/>
			</td>
			<td>${e.month }</td>
			<td>${e.mname }</td>
			<td>${e.jumin }</td>
			<td>${e.email }</td>
			<td>${e.job }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>