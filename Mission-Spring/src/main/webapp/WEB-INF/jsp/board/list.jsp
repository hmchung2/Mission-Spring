<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/layout.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" /> 
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
				
		$('#addBtn').click(function() {
			location.href = "writeForm.jsp"
		})
	})
	
/* 	function doAction(no) {
		<c:choose>
			<c:when test="${ not empty userVO}">
				location.href = 'detail.jsp?no='+no + '&from=list'						
			</c:when>
			<c:otherwise>
				if(confirm('로그인이 필요한 서비스입니다\n로그인페이지로 이동하시겠습니까?'))
					location.href = "/Mission-Web/jsp/login/login.jsp"
			</c:otherwise>
		</c:choose>
	} */
</script>
</head>
<body>
	<header>
	<%-- 	<jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
		<hr>
		<h2>게시판 목록</h2>
		<hr>
		<br>
		<table style="width: 100%" id="list">
			<tr>
				<th width="7%">번호</th>
				<th>제목</th>
				<th width="16%">작성자</th>
				<th width="20%">등록일</th>
			</tr>
			<c:forEach items="${ list }" var="board" varStatus="loop">
				<tr 
					<c:if test="${ loop.index mod 2 ne 0 }"> class="odd" 
					</c:if>>
					<td>${ board.no }</td>
					<td>
						 <a href="${pageContext.request.contextPath }/board/${board.no}">
						<%-- <a href="#" onclick="doAction()"> --%>
						<%-- <a href="javascript:doAction(${ board.no })"> --%>
							<c:out value="${ board.title }" />
						</a>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<c:if test="${ not empty userVO }">
			<button id="addBtn">새글등록</button>
		</c:if>
		<br>
		<br>
	</div>
	</section>
	<footer>
	<%-- 	<%@ include file="/jsp/include/bottom.jsp" %> --%>
	</footer>
</body>
</html>