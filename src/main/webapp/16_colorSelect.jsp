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
span.class1:hover {
	color: red;
}

span.class2:hover {
	color: green;
}

span.class3:hover {
	color: blue;
}
</style>
<body>
	<c:if test="${param.color==1}">
		<span class="class1" style="background: red;">빨강</span>
	</c:if>
	<c:if test="${param.color==2}">
		<span class="class2" style="background: green;">초록</span>
	</c:if>
	<c:if test="${ param.color==3}">
		<span class="class3" style="background: blue;">파랑</span>
	</c:if>
	<%=request.getParameter("color")%>

</body>
</html>