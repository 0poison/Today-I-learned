<%@page import="model.MemberDAO"%>
<%@page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제 중입니다.</title>
</head>
<body>
	<h2 align="center">삭제가 완료되었습니다.</h2>

	<%
	request.setCharacterEncoding("UTF-8");
	String pass1 = request.getParameter("pass1");
	%>
	<!--  회원 삭제 -->
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty property="*" name="mbean" />
	</jsp:useBean>
	<%
	MemberDAO mdao = new MemberDAO();
	String pass = mdao.getPass1(request.getParameter("id"));

	//기존에 있던 패스워드와 입력한 패스워드를 비교
	if (pass.equals(pass1)) {
		mdao.deleteMember(mbean.getId());
	} else {
	%>
	<script type="text/javascript">
		alert("패스워드가 맞지 않습니다. 다시 확인해주세요")
		history.go(-1);
	</script>
	<%
	}
	%><script>setInterval(() => {
		location.href='MemberView.jsp'
	}, 2000);</script>
</body>
</html>