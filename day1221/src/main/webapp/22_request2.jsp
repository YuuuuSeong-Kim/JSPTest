<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//프로토콜
	String protocol = request.getProtocol();

	//서버이름
	String serverName = request.getServerName();
	
	//포트번호
	//정수를 반한
	int port = request.getServerPort();
	
	//요청한 클라이언트의 ip주소를 갖고 온다.
	String remoteAddr = request.getRemoteAddr();
	
	//요청한 사용자 컴퓨터의 이름을 읽어 온다.
	String remoteHost = request.getRemoteHost();
	
	//서비스 요청방식을 읽어 온다.
	String method = request.getMethod();
	
	//클라이언트가 웹 브라우저에 입력한 주소표시줄의 내용을
	//http부터 모두 읽어 온다.
	StringBuffer reuqestURL = request.getRequestURL();
	
	//클라이언트가 웹브라우저의 입력한 주소표시줄의 내용중에
	//컨텍스트명 부터 읽어 온다.
	String reuqestURI = request.getRequestURI();
	
	//클라이언트의 접속한 웹브라우저의 정보를 읽어 온다.
	String userBrower = request.getHeader("User-Agent");
	
	//클라이언트가 접속한 웹브라우저가 지원가능한 파일타입을 모두
	///읽어 온다.
	String fileType = request.getHeader("Accept");
%>

<h1>Request Example2</h1>
프로토콜 : <%=protocol %><br>
서버의 이름 : <%= serverName %><br>
서버의 포트 번호 : <%=port %><br>
사용자 컴퓨터의 주소 : <%=remoteAddr %><br>
사용자 컴퓨터의 이름 : <%=remoteHost %><br>
요청 방식 : <%=method %><br>
요청 경로(URL) : <%=reuqestURL %><br>
요청 경로(URI) : <%=reuqestURI %><br>
요청한 클라이언트의 브라우저 : <%=userBrower %><br>
브라우저가 지원하는 파일 형식 : <%=fileType %>

</body>
</html>



