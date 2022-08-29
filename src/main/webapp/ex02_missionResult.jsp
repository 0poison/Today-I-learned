<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.getParameter("userid");
	request.getParameter("pwd");
	%>
	회원님의 아이디와 비밀번호는 다음과 같습니다.
	<br> 아이디:${param.userid}
	<br> 비밀번호: ${param.pwd }
	<br>
	<c:choose>
		<c:when test="${param.admin==1}">
			<span style="color: red;">사용자</span>
		</c:when>
		<c:when test="${param.admin==2}">
			<span style="color: green;">관리자</span>
		</c:when>
	</c:choose>
</body>
</html>