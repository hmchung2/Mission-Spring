<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
		empty userVO  : ${empty userVO } <br>
		userVO : ${sessionScope.userVO } <br>
	<hr>

	<h1>hello</h1>
	<a href="${pageContext.request.contextPath}/board">게시글</a> <br>
	<a href="${pageContext.request.contextPath}/board/write">새글등록</a><br>
	<c:if test="${ empty userVO }">
		<a href="${pageContext.request.contextPath}/login">로그인</a><br>
	</c:if>
		
	<c:if test="${ not empty userVO }">
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a><br>
	</c:if>	
</body>
</html>