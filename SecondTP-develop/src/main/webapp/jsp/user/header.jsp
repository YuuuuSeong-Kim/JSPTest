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

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header id="header" class="header">
        <h1 class="logo"><a href="main.html"><img src="../../image/logo.png" 모두의자격증"></a> </h1>
        <nav class="menuBar">
            <ul class="gnb">
                <li><a href="#">자격증정보</a></li>
                <li><a href="#">스터디모집</a></li>
                <li><a href="#">마이페이지</a></li>
                <li><a href="#">고객센터</a></li>
            </ul>
        </nav>
        <div class="topMenu">
            <ul class="TM">
                <li><a href="login.do">로그인</a></li>
                <span>&nbsp;|&nbsp;</span>
                <li><a href="join.do">회원가입</a></li>
                <i class="fa-solid fa-magnifying-glass"></i>
            </ul>
            <input class="searchBar" id="searchBar" name="searchBar" type="text" size="28" />
        </div>

    </header>
</body>
</html>