<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/style.css"/>
<link rel="stylesheet" href="${path}/resources/css/style_board.css" type="text/css" />
</head>
<body>
<div class="container">
	<%@include file="../header.jsp"%>
</div>
<section class="board">
 	<div class="page-title">
       	<div class="container">
           	<h3>게시판</h3>
       	</div>
    </div>

   <!-- board seach area -->
   	<div id="board-search">
       	<div class="container">
           	<div class="search-window">
                <form action="">
                    <div class="search-wrap">
                    	<select name="findkey" id="selSearchOption">
	        	        	<option value="subcon" <c:out value="${b_page.findkey=='subcon'?'selected':''}"/>>제목+내용</option>
							<option value="subject" <c:out value="${b_page.findkey=='subject'?'selected':''}"/>>제목</option>
							<option value="content" <c:out value="${b_page.findkey=='content'?'selected':''}"/>>내용</option>
							<option value="name" <c:out value="${b_page.findkey=='name'?'selected':''}"/>>작성자</option>   
	                 	</select>
                        <input id="search" type="search" name="findvalue"  placeholder="검색어를 입력해주세요." value="${b_page.findvalue}" >
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
  
 <!-- board list area -->
    <div id="board-list">
    	<div class="container">
        	<table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="th-num">번호</th>
                    <th scope="col" class="th-title">제목</th>
                    <th scope="col" class="th-name">작성자</th>
                    <th scope="col" class="th-date">작성일</th>
                    <th scope="col" class="th-readcnt">조회수</th>
                </tr>
                </thead>
                <tbody id="bold">
	                <c:forEach var="notice" items="${nlist}">
		                <tr>
		                    <td><i class="fa-solid fa-thumbtack"></i></td>
		                    <th class="list-title" onclick="location.href='${path}/board/noticeDetail?nnum=${notice.nnum}'">${notice.subject}</th>
		                    <td><a href="${path}/board/list?findkey=name&findvalue=${notice.name}">${notice.name}</a></td>
		                    <td>${notice.createtime}</td>
		                    <td>${notice.readcnt}</td>
		                </tr>
		            </c:forEach>
                </tbody>
                <tbody>
	                <c:forEach var="board" items="${blist}">
		                <tr>
		                    <td>${board.bnum}</td>
		                    <th style="font-weight: normal" class="list-title" onclick="location.href='${path}/board/boardDetail?bnum=${board.bnum}'">${board.subject}
		                    		<c:if test="${board.replycnt ne 0}">
										[&nbsp;<c:out value="${board.replycnt}"/>&nbsp;]
									</c:if></th>
		                    <td><a href="${path}/board/list?findkey=name&findvalue=${board.name}">${board.name}</a></td>
		                    <td>${board.createtime}</td>
		                    <td>${board.readcnt}</td>
		                </tr>
		            </c:forEach>
                </tbody>
            </table>
            <i id="boardAdd" onclick="location.href='${path}/board/boardAdd'" class="fa-solid fa-pencil fa-pull-right fa-border">글쓰기</i>
			<i id="noticeAdd" onclick="location.href='${path}/board/noticeAdd'" class="fa-solid fa-bullhorn fa-pull-right fa-border manager">공지하기</i>
        </div>
       	<div id=divPaging>
			<div><c:if test="${b_page.startPage != 1}">
				<a href="${path}/board/list?curPage=${b_page.startPage-1}">◀</a></c:if>
			</div>
			<div><c:forEach var="i" begin="${b_page.startPage}" end="${b_page.endPage}">
				<a href="${path}/board/list?curPage=${i}">${i}</a></c:forEach>
			</div>	
			<div><c:if test="${b_page.endPage<b_page.totPage}">	
				<a href="${path}/board/list?curPage=${b_page.endPage+1}">▶</a></c:if>
			</div>
			
		</div>
    </div>
</section>

</body>
<%@include file="../footer.jsp" %>
</html>