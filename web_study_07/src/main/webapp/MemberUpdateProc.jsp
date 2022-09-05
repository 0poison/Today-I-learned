<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
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
	request.setCharacterEncoding("UTF-8");
	%>
	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty property="*" name="mbean" />
	</jsp:useBean>
	<%
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	String pass = mdao.getPass1(id);
	//기존에 있던 패스워드와 입력한 패스워드를 비교
	if (mbean.getPass1().equals(pass)) {
		mdao.updateMember(mbean);
		response.sendRedirect("MemberList.jsp");
	} else {
	%>
	<script type="text/javascript">
		alert("패스워드가 맞지 않습니다. 다시 확인해 주세요");
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>