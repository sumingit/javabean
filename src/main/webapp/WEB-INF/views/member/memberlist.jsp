<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includeFile.jsp" %> 
<%@ include file="../include/sessionCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/style_board.css">
<style type="text/css">
	.board-table{
		
		
	}
	.board-table th, .board-table td {
      padding: 10px;
      border: 1px solid #ddd;
	}
	 .board-table th:first-child, .board-table td:first-child {
      border-left: 0;
    }
    .board-table th:last-child, .board-table td:last-child {
      border-right: 0;
    }
    .board-table tr td:first-child{
      text-align: center;
    }

</style>



</head>

<body >
<div class="container" style="width: 1070px;">
	<%@include file="../header.jsp"%>
</div>
    <div class="container">
        <h3>사원조회</h3>
    </div>
    
    <div id="board-search">
        <div class="container">
            <div class="search-window">
                <form action="${path}/member/memberlist">
                    <div class="search-wrap">
                        <select name="findkey">
							<option value="name" <c:out value="${m_page.findkey=='name'?'selected':''}"/>>성명</option>
							<option value="teamname" <c:out value="${m_page.findkey=='teamname'?'selected':''}"/>>부서명</option>
							<option value="gradename" <c:out value="${m_page.findkey=='gradename'?'selected':''}"/>>직급명</option>
						</select>
                        <input id="search" type="search" name="findvalue"  placeholder="검색어를 입력해주세요." value="${m_page.findvalue}">
                        <button type="submit" class="btn btn-dark">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <div id="board-list">
        <div class="container">
            <table class="board-table">
                <thead>
	                <tr>
	                    <th scope="col" class="th-num" style="width: 160px;">부서</th>
	                    <th scope="col" class="th-title">직급</th>
	                    <th scope="col" class="th-date" style="width:160px;">성명</th>
	                </tr>
                </thead>
                <tbody>
                <tr>
                	<c:forEach var ="member" items="${mlist}">
						<tr>
							<td>${member.teamname}</td>
							<td>${member.gradename} </td>
							<td><a href = "${path}/member/memberdetail?mid=${member.mid}">${member.name}</a></td>
						</tr>
		        	</c:forEach> 
                </tr>
                </tbody>
            </table>
        </div>
        <div id=divPaging>
			<div><c:if test="${m_page.startPage != 1}">
				<a href="${path}/member/memberlist?curPage=${m_page.startPage-1}">◀</a></c:if>
			</div>
			<div><c:forEach var="i" begin="${m_page.startPage}" end="${m_page.endPage}">
				<a href="${path}/member/memberlist?curPage=${i}">${i}</a></c:forEach>
			</div>	
			<div><c:if test="${m_page.endPage<m_page.totPage}">	
				<a href="${path}/member/memberlist?curPage=${m_page.endPage+1}">▶</a></c:if>
			</div>
			
		</div>
    </div>
	
	
	
</body>
<%@include file="../footer.jsp" %>
</html>