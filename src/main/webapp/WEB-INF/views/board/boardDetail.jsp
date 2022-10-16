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
<script type="text/javascript" src="${path}/resources/js/boardDetail.js"></script>
<script type="text/javascript" src="${path}/resources/js/boardReply.js"></script>
<link rel="stylesheet" href="${path}/resources/css/style_board_detail.css" type="text/css" />
<link rel="stylesheet" href="${path}/resources/css/style.css"/>
<!-- 댓글리스트 탬플릿 소스 -->
<script type="text/x-handlebars-template" id="template_source">
	{{#each .}}
		<div class="divReply" id='reply{{rnum}}'>
			{{#levelSpace relevel}} <!--헬퍼작성:levelSpace(헬퍼의 이름) -->
			{{/levelSpace}}
			<div >
				<span style="display:none;">{{rnum}}</span>
				<span style="display:none;" id="restep{{rnum}}">{{restep}}</span> 
				<span style="display:none;" id="relevel{{rnum}}">{{relevel}}</span> <br>

				<div class="hidden">
					아이디 : <span id="replymid{{rnum}}">{{mid}}</span> <br>
				</div>
				<i class="fa-solid fa-user"></i><span> {{name}}</span> <br>
				<span> {{moditime}}</span> <br>
  				{{#sessionCheck mid rnum content}}
				{{/sessionCheck}}
				<button class="reReplyAddShow" value="{{rnum}}">댓글</button>
			</div>
		</div>
		<hr>
	{{/each}}
</script>

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
					<td colspan="3" id="boardMid">${board.mid }</td>
				</tr>
				<tr class="hidden">
					<th>로그인한 아이디</th>
					<td colspan="3" id="curMid">${sessionScope.mid }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">글 번호</th>
					<td id="bnum">${board.bnum }</td>
					<th scope="row" style="text-align: center; padding-left: 0px">조회수</th>
					<td>${board.readcnt }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">작성자</th>
					<td>${board.name }</td>
					<th scope="row" style="text-align: center; padding-left: 0px">작성시간</th>
					<td>${board.createtime }</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">첨부파일</th>
					<td colspan="3">
						<c:forEach var="boardFile" items="${bflist}">
							<span class="iconDownload">${boardFile.filename }</span><br>
						</c:forEach>
					</td>
				</tr>
				<tr>
					<th scope="row" style="text-align: center; padding-left: 0px">제목</th>
					<td colspan="3">${board.subject }</td>
				</tr>
				<tr>
					<td colspan="4">${board.content }</td>
				</tr>				
			</tbody>
		</table>
		<div class="btn_location">
			<button class="btn" id="boardModify" onclick="location.href='${path}/board/boardModify?bnum=${board.bnum}'">수정</button>
			<button class="btn" id="replyAddShow">댓글</button>
			<button class="btn" id="boardRemove" onclick="removeCheck('${path}', ${board.bnum})">삭제</button>
			<button class="btn" onclick="location.href='${path}/board/list'">리스트</button>
		</div>

		<div class="reply_location">
			<hr id="hr">
			<!-- 댓글추가 -->
			<div class="card mb-2" id="divReplyAdd">
				<div class="card-header bg-light">
				        <i class="fa fa-comment fa"></i> REPLY 추가
				        <input type="hidden" id="restep" size="3">
				        <input type="hidden" id="relevel" size="3">
				</div>
				<div class="card-body">
					<ul class="list-group list-group-flush">
					    <li class="list-group-item">
						<div class="form-inline mb-2">
							<label for="replyemail"><i class="fa-solid fa-user"></i></label>
							<input type="text" class="form-control ml-2" id="replyemail" value="${sessionScope.name}" readonly>
						</div>
						<textarea class="form-control" id="replycontent" rows="3"></textarea>
						<button type="button" class="btn btn-dark mt-3" id="replyAdd">추가</button>
						<button type="button" class="btn btn-dark mt-3" id="replyCancel">취소</button>
					    </li>
					</ul>
				</div>
			</div>	
			<!-- 댓글수정 -->
			
			<div class="card mb-2" id="divReplyModify">
				<div class="card-header bg-light">
					<i class="fa fa-comment fa"></i> REPLY 수정
					<input type="hidden" id="replyrnumModify">
				</div>
				<div class="card-body">
					<ul class="list-group list-group-flush">
					    <li class="list-group-item">
						<textarea class="form-control" id="replycontentModify" rows="3"></textarea>
						<button type="button" class="btn btn-dark mt-3" id="replyModify" >저장</button>
						<button type="button" class="btn btn-dark mt-3" id="replyModifyCancel">취소</button>
					    </li>
					</ul>
				</div>
			</div>
			<!-- 댓글리스트 -->
			<div id="divReplyList"></div>
		</div>
	</div>
</body>
</html>