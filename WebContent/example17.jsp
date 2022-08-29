<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Java Bean</title>
</head>
<body>
	<jsp:useBean class="com.edu.beans.HelloBean" id="hello" />
	<jsp:getProperty property="name" name="hello" /><br>
	<jsp:getProperty property="number" name="hello" /><br>
	<jsp:setProperty property="*" name="hello" />

	<hr>
	<jsp:getProperty property="name" name="hello" /><br>
	<jsp:getProperty property="number" name="hello" /><br>
</body>
</html>