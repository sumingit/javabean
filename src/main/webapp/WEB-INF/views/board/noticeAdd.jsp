<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>    
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/style_board_detail.css" type="text/css" />
<link rel="stylesheet" href="${path}/resources/css/style.css"/>
<script type="text/javascript" src="${path}/resources/js/fileAdd.js"></script>
</head>
<body>
<div class="container">
	<%@include file="../header.jsp"%>
</div>
	<form action="${path}/board/noticeAdd" method="post" enctype="multipart/form-data" id="frm" >
		<div class="divide">
			<table class="board_view">
				<colgroup>
					<col width="15%">
					<col width="*"/>
				</colgroup>
				<caption>공지글 작성</caption>
				<tbody>
					<tr class="hidden">
						<th>아이디</th>
						<td><input type="text" name="mid" value="${sessionScope.mid}" readonly> </td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${sessionScope.name}</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td><input type="text" id="subject" name="subject" class="wdp_90"></input></td>
					</tr>
					<tr>
						<td colspan="2" class="view_text">
							<textarea rows="20" cols="100" title="내용" id="content" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<th>파일첨부<br><button onclick="fileAdd(event)">+</button></th>
						<td>
							<div id="divFiles">
								<input type="file" name="files"> <br>
							</div>
						</td>
					</tr>	
				</tbody>
			</table>
			<div class="btn_location">
				<button class="btn manager" >작성하기</button>
				<button class="btn" type="reset" OnClick="location.href='${path}/board/list'">목록으로</button>
			</div>
		</div>	
	</form>
</body>
</html>