<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginOk" method="post">
		아이디:<input type="text" name="id"><br> 비밀번호:<input
			type="password" name="pw"><br> <br> <input
			type="submit" value="로그인">&nbsp;&nbsp; <input type="submit"
			value="로그인">&nbsp;&nbsp;<input type="button" value="회원가입"
			onclick="javascript:window.location='join.jsp'">
	</form>

</body>
</html>