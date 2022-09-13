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
	${param.userid }님
	<c:choose>
		<c:when test="${param.admin==1}">사용자로</c:when>
		<c:otherwise>관리자로</c:otherwise>
	</c:choose>
	로그인 하셨습니다.
</body>
</html>