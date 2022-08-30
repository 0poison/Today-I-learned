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
	String[] hobby = request.getParameterValues("hobby");

	//배열에 있는 내용을 하나의 스트림으로 저장(문자열)
	String texthobby = "";
	texthobby = String.join(" ", hobby);
	for (int i = 0; i < hobby.length; i++) {
		texthobby += hobby[i] + " ";
	}
	%>
	<!-- useBean 액션태그를 사용하여 객체 생성 id="mbean", setProperty 액션태그를
	사용하여 데이터의 값을 설정	 -->

	<jsp:useBean id="mbean" class="model.MemberBean">
		<jsp:setProperty property="*" name="mbean" />
	</jsp:useBean>
	

	<%
	mbean.setHobby(texthobby);
	MemberDAO mdao = new MemberDAO();
	mdao.insertMember(mbean);
	response.sendRedirect("MemberList.jsp");
	%>
	OK MemberJoinProc!!
</body>
</html>