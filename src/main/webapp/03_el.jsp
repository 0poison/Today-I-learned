<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	\${5+2}:${5+2}
	<br> \${5/2}:${5/2}
	<br> \${5%2}:${5%2}
	<br> \${5>2}:${5>2}
	<br> \${(5>2)?5:2}:${(5>2)?5:2}
	<br> \${(5>2)||(2<10)}:${(5>2)||(2<10)}
	<br> \${(5>2)&&(2<10)}:${(5>2)&&(2<10)}
	<br>
	<%
	String input = null;
	%>
	\${empty input}:${empty input}
	<br>
	<br>

	<%
	if (input == null) {
		out.println("텅 빈 객체(null)입니다." + "<br>");
	}
	%>
	<!-- JSTL(JSP Standard Tag Library) -->
	<c:if test=${empty input}>
	텅 빈 객체입니다.
</c:if>


</body>
</html>