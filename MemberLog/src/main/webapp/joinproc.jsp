<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 중입니다.</title>
<style>
button {
	text-align: center;
}

h2 {
	text-align: center;
}
</style>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<!--  회원 삭제 -->
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty property="*" name="mbean" />
	</jsp:useBean>
	<%
	MemberDAO dao = new MemberDAO();
	dao.insertMember(mbean);
	%>
	<h2>회원 가입이 완료 되었습니다.</h2>
	<script>setInterval(() => {
		location.href='MemberView.jsp'
	}, 2000);</script>
</body>
</html>