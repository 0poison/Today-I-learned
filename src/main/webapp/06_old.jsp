<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--request.getParameter() 값을 찾지 못하면 null값을 리턴하기 때문에 예외 발생 --%>
	자바 코드
	<br> ==연산자 사용 결과
	<%=request.getParameter("id") == "pinksung"%>
	<br> equals() 사용 결과
	<%=request.getParameter("id") == "pinksung"%>
</body>
</html>