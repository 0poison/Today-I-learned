<%@ page import="model.MemberDAO"%>
<%@ page import="model.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>$Title$</title>
</head>
<body>

	<%
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	MemberBean mbean = mdao.oneSelectMember(id);
	%>
	<div align="center">
		<h2>회원 정보 수정 하기</h2>
			<table width="400" border="1">
			<form action="MemberUpdateProc.jsp" method="post">
			<tr height="50">
					<td align="center" width="150">아이디</td>
					<td width="250"><%=mbean.getId()%></td>
				</tr>

				<tr height="50">
					<td align="center" width="150">이메일</td>
					<td width="250"><input type="email" name="email"
						value="<%=mbean.getEmail()%>"></td>
				</tr>

				<tr height="50">
					<td align="center" width="150">전화번호</td>
					<td width="250"><input type="tel" name="tel"
						value="<%=mbean.getTel()%>"></td>
				</tr>

				<tr height="50">
					<td align="center" width="150">패스워드</td>
					<td width="250"><input type="password" name="pass1"></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><input type="hidden" name="id"
						value="<%=mbean.getId()%>"> <input type="submit"
						value="회원 수정하기">&nbsp;&nbsp;
						</form>

						<button type="button" onclick="location.href='MemberList.jsp'">회원전체
							보기</button></td>
				</tr>

			</table>
	</div>
</body>
</html>