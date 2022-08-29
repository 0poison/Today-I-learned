<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	java.util.List<String> seasonList = new java.util.ArrayList<String>();
	seasonList.add("봄");
	seasonList.add("여름");
	seasonList.add("가을");
	seasonList.add("겨울");
	request.setAttribute("list", seasonList);
	%>
	<select>
		<%
		java.util.ArrayList<String> list = (java.util.ArrayList<String>) request.getAttribute("list");
		for (int i = 0; i < list.size(); i++) {
		%>
		<option><%=list.get(i)%></option>
		<%
		}
		%>
	</select>
</body>
</html>