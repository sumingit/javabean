<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${path}/resources/js/memberJoin.js"></script> 
<link rel="stylesheet" href="${path}/resources/css/button.css">
<style type="text/css">
    #wrapper{
        width:400px;
        margin:auto;
    }

    #wrapper{
        width:fit-content;
        margin:auto;
      	style="background-color:skyblue;"
    }

    .buttonid{
        width:120px;
        margin:auto;
        display:block;
    }

	#divInfo{
		display: flex;
		justify-content: center;
	}    
	.container_a {
		 width: 800px;
 		 margin: 0 auto;
</style>
</head>

<body>
<div class="container" style="width: 1070px;">
	<%@include file="../header.jsp"%>
</div>
		<div>
			<h2>개인정보수정</h2>
		</div>
		
	<div class="container">
   		 <button class="buttonid" id="mchangepasswd" type= "button" onclick = "location.href='${path}/member/newpasswd?mid=${member.mid}'" style="float:right" class="btn-gradient blue small lalala"> 비밀번호변경 </button>
   		 <button class="buttonid" id="msave" type="button" onclick="modifyCheck(event)" style="float:right" class="btn-gradient blue small"> 저장 </button>
   		 <button class="buttonid" id="mdelete" type="button" onclick="location.href='${path}/member/memberdelete?mid=${member.mid}'" style="float:right" class="btn-gradient blue small"> 삭제 </button>
	</div>
	
	<form name = "membermodify" id= "membermodify" action="${path}/member/membermodify" method="post" enctype="multipart/form-data">
	

	<hr style="width: 1070px;">
	
	<div class="container_a">
		<h4>개인정보</h4>
	</div>
	
	
	<div id="divInfo">
		<input type="hidden" name="filename" value="${member.filename}">
		<input type="hidden" id="gcode" value="${sessionScope.gcode}">
		<img alt="" src="${path}/savedir/${member.filename}" width="200" height="200"> 
		<input type="file" name="photofile" >
	</div>
	<div id="divInfo">
		<table border="1" id="divInfo">
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" id="name" value="${member.name}"></td>
				<th>생년월일</th>
				<td><input type="text" name="birthday" id="birthday" value="${member.birthday}"></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="mobile" id="mobile" value="${member.mobile}"></td>
				<th>이메일</th>
				<td><input type="text" name="email" id="email" value="${member.email}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="addrload" id="addrload" value="${member.addrload}"></td>
				<th>상세주소</th>
				<td><input type="text" name="addrdetail" id="addrdetail" value="${member.addrdetail}"></td>
			</tr>
			</table>
		</div>
		<hr style="width: 1070px;">
		<div class="container_a">
			<h4>사원정보</h4>
		</div>
		<div id="divInfo">
			<table border="1" id="divInfo">
			<tr>
				<th>아이디</th>
				<td><input type="text"  name ="mid" id="mod_mid" value="${member.mid}" readonly></td>
				<th>입사일</th>
				<td><fmt:formatDate value="${member.regidate}" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<th>부서</th>
				<td>
					<select name="tcode" id="mod_teamname">
						<option value="1">대표이사</option>
						<option value="2">경영팀</option>
						<option value="3">인사팀</option>
						<option value="4">개발팀</option>
					</select>
				</td>
				<th>직급</th>
				<td>
					
					<select name="gcode" id="mod_gradename">
						<option value="1">전무이사</option>
						<option value="2">팀장</option>
						<option value="3">과장</option>
						<option value="4">대리</option>
					</select>
				</td>
			</tr>
			</table>
		</div>
	</form>
	
	
</body>
</html>