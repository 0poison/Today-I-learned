<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>덧셈</title>
</head>
<body>
	<h3>선언문으로 구현한 덧셈</h3>
	<%!public int sum(int a, int b) {
		return a + b;
	}%>
	덧셈의 결과 :
	<%=this.sum(20, 30)%>
</body>
</html>