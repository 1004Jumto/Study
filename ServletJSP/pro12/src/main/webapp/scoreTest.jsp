<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점변환기</title>
</head>
<body>
	<h1>시험점수 <%=score %>점</h1><br>
	<%
	if(score >= 90) {
	%>
	<h1>A 학점입니다</h1>
	<%
	}else if(score >= 80 && score < 90) {
	%>
	<h1>B 학점입니다</h1>
	<%
	}else if(score >= 70 && score < 80) {
	%>
	<h1>C 학점입니다</h1>
	<%
	}else if(score >= 60 && score < 70) {
	%>
	<h1>D 학점입니다</h1>
	<%
	}else {
	%>
	<h1>F 학점입니다</h1>
	<%
	}
	%>
	
	<br>
	<a href="scoreTest.html">시험점수 입력</a>
</body>
</html>