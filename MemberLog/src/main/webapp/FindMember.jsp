<%@page import="model.MemberBean"%>
<%@page import="model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>
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
		<h2>회원 찾기</h2>
		<table width="100%" border="1">
			<tr height="50">
				<td align="center" width="150">아이디</td>
				<td align="center" width="150">이메일</td>
				<td align="center" width="150">전화</td>
				<td align="center" width="150">취미</td>
				<td align="center" width="150">직업</td>
				<td align="center" width="150">나이</td>
				<td align="center" width="150">정보</td>
			</tr>
			<tr>
				<td width="250"><%=mbean.getId()%></td>
				<td width="250"><%=mbean.getEmail()%></td>
				<td width="250"><%=mbean.getTel()%></td>
				<td width="250"><%=mbean.getHobby()%></td>
				<td width="250"><%=mbean.getJob()%></td>
				<td width="250"><%=mbean.getAge()%></td>
				<td width="250"><%=mbean.getInfo()%></td>
			</tr>
		</table>
		<button type="button" onclick="location.href='MemberUpdate.jsp?id=<%=mbean.getId()%>'">회원
			수정</button>
		<!-- 개인정보가 넘어가야 하며 db에서 불러와 수정한다. -->
		<button type="button" onclick="location.href='DeleteForm.jsp?id=<%=mbean.getId()%>'">회원
			삭제</button>
		<button type="button" onclick="location.href='MemberView.jsp'">목록 보기</button>
		<button type="button" onclick="location.href='Join.jsp'">회원 가입</button>
	</div>
</body>
</html>