<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
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
	<jsp:useBean
		id="dto"
		class="com.javalec.ex.MemberDto"
	/>
	<jsp:setProperty
		property="*"
		name="dto"
	/>
	<%
	dto.setrDate(new Timestamp(System.currentTimeMillis()));
	MemberDao dao = MemberDao.getInstance();
	if (dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
	%>
	<script>
		alert("이미 존재하는 아이디입니다.");
		history.back();
	</script>
	<%
	//아이디 중복이 아닐경우
	} else {
	int ri = dao.insertMember(dto);
	if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
		session.setAttribute("id", dto.getId());
	%>
	<script>
		alert("회원 가입을 축하합니다.");
		document.location.href = "login.jsp";
	</script>
	<%
	} else {
	//아이디가 중복은 아니지만 테이블에 저장 실패
	%>
	<script>
		alert("회원가입에 실패했습니다.");
		document.location.href = "login.jsp";
	</script>
	<%
	}
	%>
	<%
	}
	%>

</body>
</html>