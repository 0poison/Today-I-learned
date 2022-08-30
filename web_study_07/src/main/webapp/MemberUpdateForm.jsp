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
	String id = request.getParameter("id");
	MemberDAO mdao = new MemberDAO();
	MemberBean mbean = mdao.oneSelectMember(id);
	%>
	<div align="center">
		<form action="MemberUpdateProc.jsp" method="post">
			<table width="400" border="1">
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
					<td align="center" width="150">전화</td>
					<td width="250"><input type="tel" name="tel"
						value="<%=mbean.getEmail()%>"></td>
				</tr>
				<tr height="50">
					<td align="center" width="150">패스워드</td>
					<td width="250"><input type="password" name="pass1"
						value="<%=mbean.getPass1()%>"></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="hidden" name="id"
						value=<%=mbean.getId()%>> <input type="submit"
						value="회원 수정하기">&nbsp;&nbsp;
						<button type="button" onclick="location.href='MemberList.jsp'">회원
							전체 보기</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>