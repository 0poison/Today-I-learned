<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	EL 식
	<hr>
	<%-- EL에서는 파라미터 값을 찾지 못하면 공백으로 처리되기 때문에 예외처리를 하지 않아도 된다. --%>
	== 연산자 사용 결과 ${param.id == "gilson"}
	<br>
	<!-- false나오는데 http://localhost:8080/web_study_06/07_new.jsp?id=gilson 변경하면 true로 됨 -->
</body>
</html>