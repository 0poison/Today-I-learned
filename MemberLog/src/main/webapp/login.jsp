<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	MemberBean mbean = mdao.oneSelectMember(id);
	%>
	<form action="login.do" method="post">
		아이디:<input type="text" name="id" value="<%=mbean.getId()%>"><br> 비밀번호: <input
			type="password" name="pw"
		> <br> <input type="submit" value="로그인">
		<button type="button" onclick="location.href='MemberView.jsp'">회원전체 보기</button>
	</form>
</body>
</html>