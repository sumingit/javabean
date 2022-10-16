<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/login_join.css">
<script type="text/javascript" src="${path}/resources/js/login.js"></script>

</head>
<body>
<div class="container" style="width: 1070px;">
	<%@include file="./header.jsp"%>
</div>
            <header>
            <h2>Login</h2>
        </header>

        <form action="" method="POST" style="width: 50%;margin: 0 auto;">


            <div class="input-box">
                <input id="mid" type="text" name="mid" placeholder="아이디">
                <label for="mid">아이디</label>
            </div>

            <div class="input-box">
                <input id="passwd" type="password" name="passwd" placeholder="비밀번호">
                <label for="passwd">비밀번호</label>
                
            </div>
            
            <input type="submit" value="로그인">

        </form>

</body>
</html>