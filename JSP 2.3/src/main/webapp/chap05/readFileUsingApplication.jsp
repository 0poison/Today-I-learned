<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head> <title>application 기본 객체를 사용하여 자원 읽기</title> </head>
<body>

 <%
 String resourcePath = "\\message\\notice.txt";
 %>
 자원의 실제경로:
 <br><%=application.getRealPath(resourcePath)%>
 <br> ---------
 <br>
 <%=resourcePath%>의 내용
 <br>----------
 <br>
 <%
 char[] buff = new char[128];
 int len = -1;
 try (InputStreamReader br = new InputStreamReader(
   application.getResourceAsStream(resourcePath), "UTF-8")) {
 	while ((len = br.read(buff)) != -1) {
 		out.print(new String(buff, 0, len));
 	}
 } catch (IOException ex) {
 	out.println("익셉션 발생: " + ex.getMessage());
 }
 %>
 
</body>
</html>