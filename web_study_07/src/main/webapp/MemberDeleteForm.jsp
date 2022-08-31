<%@ page import="model.MemberDAO"%>
<%@ page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
	<h2>회원 삭제하기</h2>
	<form action="MemberDeleteProc.jsp" method="post">
		<table width="400" border="1">
			<tr height="50">
				<td align="center" width="150">아이디</td>
				<td width="250"><%=request.getParameter("id")%></td>
			</tr>

			<tr height="50">
				<td align="center" width="150">패스워드</td>
				<td width="250"><input type="password" name="pass1"></td>
			</tr>

			<tr height="50">
				<td align="center" width="150"><input type="hidden" name="id"
					value="<%=request.getParameter("id")%>"> <input
					type="submit" value="회원 삭제하기">&nbsp;&nbsp;
					<button type="button" onclick="location.href='MemberList.jsp'">회원
						전체보기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>