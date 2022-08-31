<%@ page import="model.MemberDAO"%>
<%@ page import="model.MemberBean"%>
<%@ page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>$Title$</title>
</head>
<body>
	<%
	MemberDAO mdao = new MemberDAO();
	Vector<MemberBean> vec = mdao.allSelectMember();
	%>

	<div align="center">
		<h2>모든 회원 보기</h2>
		<table width="800" border="1">
			<tr height="50">
				<td align="center" width="150">아이디</td>
				<td align="center" width="250">이메일</td>
				<td align="center" width="200">전화번호</td>
				<td align="center" width="200">취미</td>
			</tr>

			<%
			for (int i = 0; i < vec.size(); i++) {
				MemberBean mbean = vec.get(i);
			%>

			<tr height="50">
				<td align="center" width="150"><a
					href="MemberInfo.jsp?id=<%=mbean.getId()%>"> <%=mbean.getId()%></a>
				</td>
				<td align="center" width="250"><%=mbean.getEmail()%></td>
				<td align="center" width="250"><%=mbean.getTel()%></td>
				<td align="center" width="250"><%=mbean.getHobby()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>