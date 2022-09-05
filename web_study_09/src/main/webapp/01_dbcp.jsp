<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.*"%>
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
	<h4>DB연동</h4>
	DBCP(DataBase Connection Pool)
	<%
	Context context = null;
	DataSource datasource = null;
	Connection connection = null;
	try {
		context = new InitialContext();
		datasource = (DataSource) context.lookup("java:/comp/env/jdbc/Oracle11g");
		connection = datasource.getConnection();
		// 		connetion pool에서 db를 사용할 수 있는 방법

	} catch (Exception e) {
		e.printStackTrace();
	}
	out.print(connection);
	%>

</body>
</html>