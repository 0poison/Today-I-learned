<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Result</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	%>
	<%=id%> / <%=pwd%>
</body>
</html>