<%@page import="model.BoardDAO"%>
<%@page import="model.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="boardBean" class="model.BoardBean">
		<jsp:setProperty name="boardBean" property="*"></jsp:setProperty>
	</jsp:useBean>
	<%
	BoardDAO bdao = new BoardDAO();
	String pass = bdao.getPass(boardBean.getNum());
	if (pass.equals(boardBean.getPassword())) {
		bdao.updateBoard(boardBean);
		response.sendRedirect("BoardList.jsp");
	} else {
	%>
	<script type="text/javascript">
		alert("패스워드가 일치하지 않습니다. 다시 확인 후 수정해 주세요");
		history.go(-1);
	</script>
	<%
	}
	%>
</body>
</html>