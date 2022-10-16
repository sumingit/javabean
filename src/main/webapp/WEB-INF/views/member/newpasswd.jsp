<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<%@ include file="../include/sessionCheck.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/passwd.css">
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script>
</head>
<body>
<div class="container" style="width: 1070px;">
	<%@include file="../header.jsp"%>
</div>
 	<form name="pwModify" id="pwModify" action="${path}/member/newpasswd" method="post" >
 	<div class = "change_pw">
 		<h2>비밀번호 변경</h2>
 		<p class="info">
             회원님의 개인정보를 안전하게 보호하고, 개인정보 도용으로 인한 피해를 예방하기 위해<br />
            6개월 이상 비밀번호를 변경하지 않은 경우 비밀번호 변경을 권장하고 있습니다.
        </p>
        <input type="hidden" name="mid" value="${member.mid}">
 		<table>
				
			<tr>
			
				<th>기존비밀번호</th>
				<td><input type="password" name="oldPasswd" id="oldPasswd"> </td>
			</tr>
			<tr>
				<th>변경비밀번호</th>
				<td><input type="password" name = "newPasswd" id="newPasswd"> </td>
			</tr>			
			<tr>
				<th>변경비밀번호확인</th>
				<td><input type="password" id="newPasswdConfirm"> </td>
			</tr>			
			<tr>
				<td colspan="2" align="center">
					<button type = "button" onclick="pwCheck(event)"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_change.gif" alt="비밀번호 변경하기" /></button> 
					<button type="reset" onclick = "location.href='${path}/member/membermodify?mid=${param.mid}'"><img src="http://img.echosting.cafe24.com/skin/base_ko_KR/member/btn_change_next.gif" alt="다음에 변경하기" /></button>
				</td>
			</tr>	
		</table> 
    </div>
    </form>
</body>
</html>