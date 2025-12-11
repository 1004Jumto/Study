<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
</head>
<body>
	<h1>hello JSP</h1>
	<h1>JSP 실습입니다.</h1>
	
	<%
	String name = "발광머리 앤";
	out.print(name + "\n");
	out.print(new Date());
	%>
</body>
</html>