<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!String name, id, pw;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	id = (String) session.getAttribute("id");
	pw = (String) session.getAttribute("pw");
	%>
	<%=id%>님 안녕하세요
	<br>
	<script>setInterval(() => {
		location.href='MemberUpdate.jsp'
	}, 2000);</script>
</body>
</html>