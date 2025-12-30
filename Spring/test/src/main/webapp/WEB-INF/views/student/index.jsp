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
<h1>학생 목록</h1>
<form>
<input type="checkbox" name="searchMajor" value="101"> 컴퓨터공학과
<input type="checkbox" name="searchMajor" value="102"> 멀티미디어공학과
<input type="checkbox" name="searchMajor" value="103"> 소프트웨어공학과
<input type="checkbox" name="searchMajor" value="201"> 전자공학과
<input type="checkbox" name="searchMajor" value="202"> 기계공학과
<input type="checkbox" name="searchMajor" value="301"> 문헌정보학과<br>
<select name="searchGrade">
	<option value="0">전체</option>
	<option value="1" ${param.searchGrade == '1' ? 'selected' : '' }>1학년</option>
	<option value="2" ${param.searchGrade == '2' ? 'selected' : '' }>2학년</option>
	<option value="3" ${param.searchGrade == '3' ? 'selected' : '' }>3학년</option>
	<option value="4" ${param.searchGrade == '4' ? 'selected' : '' }>4학년</option>
</select>
<select name="searchType">
	<option value="all">이름+아이디</option>
	<option value="name" ${param.searchType == 'name' ? 'selected' : '' }>이름</option>
	<option value="id" ${param.searchType == 'id' ? 'selected' : '' }>아이디</option>
</select>
<input type="text" name="searchWord" value="${param.searchWord }">
<input type="submit" value="검색">
</form>
<c:forEach var="vo" items="${list }">
	<a href="view?studno=${vo.studno }">${vo.name }</a> ${vo.id }<br>
</c:forEach>
</body>
</html>