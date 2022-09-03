<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<body>
	<c:forEach var="item" items="${paramValues.item}" varStatus="status">
		${item}
		<c:if test="${not status.last}">
		,
			</c:if>
	</c:forEach>
</body>
</html>