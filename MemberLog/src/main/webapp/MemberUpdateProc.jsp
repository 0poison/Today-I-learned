<%@ page import="model.MemberDAO"%>
<%@ page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 중입니다.</title>
</head>
<body>
	<h2 align="center">수정이 완료되었습니다.</h2>
	<script>setInterval(() => {
		location.href='MemberView.jsp'
	}, 2000);</script>
	<%
	request.setCharacterEncoding("UTF-8");
	%>
	<!--  회원 삭제 -->
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty property="*" name="mbean" />
	</jsp:useBean>
	<%
	MemberDAO dao = new MemberDAO();
	dao.updateMember(mbean);
	%>
</body>
</html>