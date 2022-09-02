<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("ValidMem") == null) {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<!-- 서버내에서 이동 -->
<%
}
String name = (String) session.getAttribute("name");
String id = (String) session.getAttribute("id");
%>
<html>
<body>
	<h1><%=name%>님 안녕하세요
	</h1>
	<form action="logout.jsp">
		<input type="submit" value="로그아웃">&nbsp;&nbsp; <input
			type="button" value="정보수정"
			onclick="javascript:window.location='modify.jsp'">
	</form>
</body>
</html>