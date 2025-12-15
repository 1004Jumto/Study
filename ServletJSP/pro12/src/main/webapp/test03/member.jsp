<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 	import="java.util.*"   
    import="sec02.ex01.*"
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<style type="text/css">
	h1{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>회원 정보 출력</h1>
	<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");
	 
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list;
	
	if(_name == null || _name.isBlank() ) {
		list = dao.listMembers();
	}
	else{
		MemberVO vo = new MemberVO();
		vo.setName(_name);
		list = dao.listMembers(vo);
	}
	%>
	
	<table border=1 width=800 align="center">
		<tr align=center bgcolor='#FFFF66'>
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>가입일자</td>
		</tr>
		
		<%
			for(int i = 0; i < list.size(); i++){
				MemberVO memberVO = (MemberVO) list.get(i);
				String id = memberVO.getId(); 
				String name = memberVO.getName();
				String email = memberVO.getEmail();
				String pwd = memberVO.getPwd();
				Date joinDate = memberVO.getJoinDate();
			
		%>
		
		<tr align=center>
			<td><%=id %></td>
			<td><%=name %></td>
			<td><%=pwd %></td>
			<td><%=email %></td>
			<td><%=joinDate %></td>
		</tr>
		
		<%
		} 
		%>
	</table>
</body>
</html>