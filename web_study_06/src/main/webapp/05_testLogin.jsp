<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	당신이 입력한 정보입니다.(request 방식)
	<hr>
	아이디:<%=request.getParameter("id")%>
	비밀번호:<%=request.getParameter("pwd")%>

	당신이 입력한 정보입니다.
	(EL방식) 아이디:${param.id} 비밀번호:${param.pwd}
	비밀번호:${param["pwd"]}

</body>
</html>