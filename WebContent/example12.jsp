<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>application</title>
</head>
<body>
	서버명 :
	<%=application.getServerInfo()%>
	<!-- 	서버의 정보 추출 -->
	<br> 서블릿 버전 :
	<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
	<!-- 	현재 서버가 지원하고 있는 서블릿의 버전을 추출 -->
	<br>
	<h3>/edu 리스트</h3>
	<%
	java.util.Set<String> list = application.getResourcePaths("/");
	// 	인자로 지정한 디렉토리 목록을 반환
	if (list != null) {
		Object[] obj = list.toArray();
		for (int i = 0; i < obj.length; i++) {
			out.print(obj[i] + "<br>");
		}
	}
	%>
</body>
</html>