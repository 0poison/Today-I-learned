<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<jsp:useBean id="boardBean" class="model.BoardBean">
		<jsp:setProperty name="boardBean" property="*" /></jsp:useBean>
	<%
	BoardDAO bdao = new BoardDAO();
	bdao.insertBoard(boardBean);

	//게시글 저장 후 전체 게시글 보기
	response.sendRedirect("BoardList.jsp");
	%>
</body>
</html>