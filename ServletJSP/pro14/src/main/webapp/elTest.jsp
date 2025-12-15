<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${name }<br>
	${member.name }<br>
	세션: ${mem }<br>
	로그인세션여부: ${empty loginSession }<br>
	${param.page }<br>
	
	
	
	<h2>JSTL</h2>
	<c:out value="${!empty loginSession }"/>		<!-- 로그인 된 상태 검사 -->
	<c:if test="${!empty loginSession }" >
	${loginSession.name }님 안녕하세요!
	</c:if>	<br>
	<c:if test="${empty loginSession }" >
	로그인하세요
	</c:if>
	
	<br>
	
	<c:forEach var="map" items="${list }">
		${map.title } 	<br>
	</c:forEach>
	
		<br>
		
	<img alt="" src="<c:url value="/img/pic1.jpg"/>">
</body>
</html>