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

    .buttonid{
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
	}
	.container_b{
		width: 800px;
 		margin: 0 auto;
	}
	    

</style> 
</head>
<body>
<div class="container" style="width: 1070px;">
	<%@include file="../header.jsp"%>
</div>
	
	<div class="">
		<h2>개인정보조회</h2>
	</div>
	
	<div class="container" >
		<button class= "buttonid" type= "button" onclick="location.href='${path}/member/memberlist'" style="float:right" class="btn-gradient blue small">리스트</button>
		<button class= "buttonid" id="mmodify" name="mmodify" type="button" onclick="location.href='${path}/member/membermodify?mid=${member.mid}'" style="float:right" class="btn-gradient blue small">수정</button>
	</div>
		
	
	
	<hr style="width: 1070px;">
	
	<div class="container_a">
		<h4>개인정보</h4>
	</div>
	
	<form action="memberdetail" method="get">
	
	
		
		
	<div id="divInfo">
			<img alt="" src="${path}/savedir/${member.filename}" width="200"> <br>			
	</div>	
	<div id="divInfo">
		<table border="1" id="divInfo">
			<tr>
				<th>성명</th>
				<td>${member.name}</td>
				<th>생년월일</th>
				<td>${member.birthday}</td>
			</tr>
			<tr>
				<th>연락처</th>
				<td>${member.mobile}</td>
				<th>이메일</th>
				<td>${member.email}</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>${member.addrload}</td>
				<th>상세주소</th>
				<td>${member.addrdetail}</td>
			</tr>
		</table>
	</div>
		
		
		<hr style="width: 1070px;">
		
		<div class="container_a">
			<h4>사원정보</h4>
		</div>
		
		<div  id="divInfo">
			<table border="1" id="divInfo">
				<tr>
					<th>아이디</th>
					<td id="memberMid" >${member.mid}</td>
					<th>입사일</th>
					<td><fmt:formatDate value="${member.regidate}" pattern="yyyy-MM-dd"/></td>
					
				</tr>
				<tr>
					<th>부서</th>
					<td>${member.teamname}</td>
					<th>직급</th>
					<td>${member.gradename}</td>
					
				</tr>
		
		</table>
		
		</div>
		
		
	</form>
	
</body>
</html>