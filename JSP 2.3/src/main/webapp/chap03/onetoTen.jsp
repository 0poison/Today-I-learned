<%@ page language="java" contentType="text/html; charset=euc-kr"%>
<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
</head>
<body>
	<%
	int sum = 0;
	for (int i = 1; i <= 10; i++) {
		sum = sum + i;
	}
	%>
	1부터 10까지의 합은
	<%=sum%>입니다.
</body>
</html>