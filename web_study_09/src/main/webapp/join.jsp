<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	type=text/javascript
	src="members.js"
></script>
</head>
<body>
	<form
		action="joinOk.jsp"
		method="post"
		name="reg_frm"
	>
		아이디: <input
			type="text"
			name="id"
			size="20"
			placeholder="4글자 이상 입력하세요"
		> <br> 비밀번호:<input
			type="password"
			name="id"
			size="20"
		><br> 비밀번호 확인:<input
			type="password"
			name="pw_check"
			size="20"
		><br> 이름:<input
			type="text"
			name="name"
			size="20"
		><br> 이메일:<input
			type="email"
			name="email"
			size="20"
		><br> 주소:<input
			type="text"
			name="address"
			size="40"
		><br> <input
			type="button"
			value="회원 가입"
			onclick="infoConfirm()"
		><input
			type="reset"
			value="취소"
			onclick="javascript:window.location='login.jsp'"
		>
	</form>
</body>
</html>