<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/header.js"></script>
</head>
<body>
	<header>
        <div id="login" style="word-spacing: 5px; float: right;">
			
			<input type="hidden" id="contextpath" value="${path}/">
			<input type="hidden" id="sessionMcode" value="${sessionScope.mcode}">
			<input type="hidden" id="sessionMid" value="${sessionScope.mid}">
			<span id="sessionName"><a href="${path}/member/memberdetail?mid=${sessionScope.mid}"> ${sessionScope.name} </a></span>
			<a href="${path}/login" id="aLogin">로그인</a>
			<a href="" id="aLogout">로그아웃</a>
			<a href="${path}/member/join" id="aJoin">회원가입</a>
		</div>
		<div id="logo">
			<a href="${path}/" >
				<img src="${path}/resources/images/logo.jpg" width="300" title="회사 로고" style="display: block; margin: 0px auto;" >
			</a>
		</div>
	</header>
	<hr>
	<nav style="word-spacing: 5px">
                    <a href="${path}/"  class="menu-item">홈</a>
                    <a href="${path}/board/"  class="menu-item">사내게시판</a>
                    <a href="${path}/calendar"  class="menu-item">근태관리</a>
                    <a href="${path}/member/memberlist"  class="menu-item">사원조회</a>            	
	</nav>
	<hr>
</body>
</html>
