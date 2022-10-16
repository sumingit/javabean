<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/login_join.css">
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>

<body>
		<%@ include file="../header.jsp" %>
		<header>
            <h2>회원가입</h2>
        </header>
        <form action="${path}/member/join" method="POST" id="frmJoin" name="frmJoin" enctype="multipart/form-data" style="width: 50%;margin: 0 auto;">


            <div class="input-box">
                <input id="mid" type="text" name="mid" placeholder="아이디" value="${member.mid}">
                <label for="mid">아이디</label>
            </div>
            <div class="input-box">
                <input id="email" type="email" name="email" placeholder="이메일" value="${member.email}">
                <label for="mid">이메일</label>
            </div>
            <div class="input-box">
                <input id="passwd" type="password" name="passwd" placeholder="비밀번호" value="${member.passwd}">
                <label for="passwd">비밀번호</label>
            </div>
            <div class="input-box">
                <input id="passwdConfirm" type="password" placeholder="비밀번호 확인">
                <label for="passwd">비밀번호 확인</label>
            </div>
            <div class="input-box">
                <input id="name" type="text" name="name" placeholder="이름" value="${member.name}">
                <label for="name">이름</label>
            </div>
            <div class="input-box">
                <input id="zipcode" type="text" name="zipcode" placeholder="우편번호" value="${member.zipcode}">
                <button type="button" class="btn btn-secondary " onclick="goPopup('${path}')">조회</button> 
                <label for="zipcode">우편번호</label>
            </div>
            <div class="input-box">
                <input id="addrload" type="text" name="addrload" placeholder="도로명주소" value="${member.addrload}">
                <label for="addrload">도로명주소</label>
            </div>
            <div class="input-box">
                <input id="addrdetail" type="text" name="addrdetail" placeholder="상세주소" value="${member.addrdetail}">
                <label for="addrdetail">상세주소</label>
            </div>
           <div class="input-box">
                <input id="mobile" type="text" name="mobile" placeholder="휴대폰번호" value="${member.mobile}">
                <label for="addrdetail">휴대폰번호</label>
            </div>
            <div class="input-box">
                <input id="birthday" type="date" name="birthday" placeholder="생년월일" value="birthday">
                <label for="date">생년월일</label>
            </div>
            <div class="input-box">
                <input id="photofile" type="file" name="photofile" placeholder="사진" value="photofile" >
                <label for="date">사진</label>
            </div>
           
            <input type="submit" value="가입" onclick="joinCheck(event)">
            <input type="reset" value="취소" class="btn btn-secondary form-control">
            
       </form>   
			
</body>
</html>