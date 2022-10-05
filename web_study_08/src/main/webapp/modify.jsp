<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection connection;
	Statement statement;
	ResultSet resultSet;

	String name, id, pw, phone1, phone2, phone3, gender;%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 	name = (String) session.getAttribute("name");
	id = (String) session.getAttribute("id");
	// 	pw = (String) session.getAttribute("pw");

	String query = "select * from member where id='" + id + "'";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	statement = connection.createStatement();
	resultSet = statement.executeQuery(query);
	while (resultSet.next()) {
		name = resultSet.getString("name");
		pw = resultSet.getString("pw");
		phone1 = resultSet.getString("phone1");
		phone2 = resultSet.getString("phone2");
		phone3 = resultSet.getString("phone3");
		gender = resultSet.getString("gender");
	}
	%>
	<form action="ModifyOk" method="post">
		이름:<input type="text" name="name" size="10" value="<%=name%>"><br>
		아이디:<%=id%><br> 비밀번호:<input type="password" name="pw" size="10"><br>
		전화번호:<select name="phone1">
			<option value="010">010</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
			<option value="011">011</option>
		</select>-<input type="text" name="phone2" size="5" value="<%=phone2%>">-<input
			type="text" name="phone3" size="5" value="<%=phone3%>"><br>
		<%
		if (gender.equals("man")) {
		%>
		성별 구분 : <input type="radio" name="gender" value="man"
			checked="checked">남&nbsp; <input type="radio" name="gender"
			value="women">여<br>
		<%
		} else {
		%>
		성별 구분 : <input type="radio" name="gender" value="man">남&nbsp;
		<input type="radio" name="gender" value="women" checked="checked">여<br>
		<%
		}
		%>
		<input type="submit" value="정보수정"><input type="reset"
			value="취소">
	</form>
	<!-- 	세션은 브라우저를 종료할 때까지 잔존 -->
</body>
</html>