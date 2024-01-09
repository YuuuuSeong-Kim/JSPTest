<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

        /* 초기화 */
        body,h1,h2,h3,div,p,ul, li,dl, dt,dd {
            margin: 0;
            padding: 0
        }

        /*바디 기본폰트설정,구글 폰트설정함*/
        body { 
            font-family: 'Poppins', 'Noto Sans KR', sans-serif;
            font-size: 14px;
            line-height: 1.5
            
        }

        .header {
            width: 1200px;
            height: 90px;
            margin: 0 auto;
            padding: 15px 10px 0px 5px;
            position: relative;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        li {
            list-style: none;
        }

        a {
            text-decoration: none;
            color: #575656;

        }

        .logo img {
            width: 260px;
            height: 90px;
        }

        .menuBar {
            width: 550px;
            height: 90px;
        }

        .gnb {
            height: 90px;
            display: flex;
            justify-content: space-between;
            font-size: 22px;
            padding-right: 20px;
        }

        .gnb li {
            align-self: center;
        }

        .topMenu {       
            padding-bottom: 13px;
            position: relative;
        }

        .TM {
            display: flex;
            justify-content: flex-end;
            font-size: 15px;
            padding: 0 5px 0 5px;
            width: 210px;
            height: 25px;
        }

        .searchBar {
            border: 3px solid #928e8e;
            border-radius: 7px;
            height: 23px;
        }
    
        /*돋보기아이콘*/
        .fa-magnifying-glass{  
            position: absolute;
            right: 9px;  /*모니터 크기에 따라 위치 달라짐.필요하면 수치조정하기 */
            bottom: 19px;
            color: #928e8e;
        }



        /*--------header CSS 끝-----*/

        /* -------main css---------*/


        /* 배너-레이아웃용이므로 삭제하고 작업 ㄱ  */
        .banner {
            width: 1fr;
            height: 320px;
            background: #DDDDDD;
        }

        .article {
            width: 1200px;
            height: 1000px;
        }


        /* -------main css끝--------*/

        

        /* ----footer CSS ---- */
        
        .footer {
            width: 1fr;
            height: 320px;
            background: #4F4A45;
            color: #ffffff;

        }

        .ft_info {
            width: 1215px;
            margin: auto;
            padding-top: 14px;
            font-size: 15px;
            position: relative;
        }

        .ft_link {
            margin: 20px;
        }

        .ft_link li {
            list-style: disc
        }

        .fa-brands{
            width: 100px;
            height: 30px;
        }
        .sns{
            width: 350px;
            height: 50px;
            position: absolute;
            right: 5px;
            bottom: 70px;
            display: flex;
            align-content: space-between;

        }

</style>
<meta charset="UTF-8">
<title>모두의 자격증, 모자</title>
</head>
<body>
	<div id="header">
		<jsp:include page="header.jsp"/>
	</div>
	<div id="content">
		<jsp:include page="${viewPage}"/>
	</div>
	<div id="footer">
		<jsp:include page="footer.jsp"/>
	</div>
</body>
</html>