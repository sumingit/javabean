<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 핸들마 탬플릿 cdn연결 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/noticeDetail.js"></script>
<link rel="stylesheet" href="${path}/resources/css/style_board_detail.css" type="text/css" />
<link rel="stylesheet" href="${path}/resources/css/style.css"/>
</head>
<body>
<div class="container">
	<%@include file="../header.jsp"%>
</div>
	<div class="divide">
		<table class="board_view">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col width="35%"/>
			</colgroup>
			<caption>게시글 상세</caption>
			<tbody>
				<tr class="hidden">
					<th>아이디</th>
					<td colspan="3" id="noticeMid">${notice.mid }</td>
				</tr>
				<tr class="hidden">
					<th>로그인한 아이디</th>
					<td colspan="3" id="curMid">${sessionScope.mid }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">글 번호</th>
					<td id="nnum" >${notice.nnum }</td>
					<th scope="row" style="text-align: center; padding-left: 0px">조회수</th>
					<td>${notice.readcnt }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">작성자</th>
					<td>${notice.name }</td>
					<th scope="row" style="text-align: center; padding-left: 0px">작성시간</th>
					<td>${notice.createtime }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">첨부파일</th>
					<td colspan="3">
						<c:forEach var="noticeFile" items="${nflist}">
							<span class="iconDownload">${noticeFile.filename }</span><br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">제목</th>
					<td colspan="3">${notice.subject }</td>
				</tr>
				<tr>
					<td colspan="4">${notice.content }</td>
				</tr>				
			</tbody>
		</table>
		<div class="btn_location">
			<button class="btn manager" id="noticeModify" onclick="location.href='${path}/board/noticeModify?nnum=${notice.nnum}'">수정</button>
			<button class="btn manager" id="noticeRemove" onclick="removeCheck('${path}', ${notice.nnum})">삭제</button>
			<button class="btn" onclick="location.href='${path}/board/list'">리스트</button>
		</div>
	</div>
</body>
</html>