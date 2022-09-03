<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (request.getParameter("id") != null){
	%>
	==연산자 사용 결과:
	<%=request.getParameter("id")=="pinksung" %><br> equals() 사용 결과:
	<%=request.getParameter("id").equals("pinksung") %><br>
	<%}else{
		out.println("id를 전달해주세요.");
	}
	%>
</body>
</html>