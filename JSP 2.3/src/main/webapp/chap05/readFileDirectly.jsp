<%@page import="java.io.*"%>
<%@ page
 language="java"
 contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 경로를 사용하여 자원 읽기</title>
</head>
<body>
 <%
 char[] buff = new char[128];
 int len = -1;
 String filePath = "C:\\Users\\user\\git\\Today-I-learned\\JSP 2.3\\src\\main\\webapp\\chap05" + "\\message\\notice.txt";
 try (InputStreamReader fr = new InputStreamReader(new FileInputStream(filePath), "UTF-8")) {
 	while ((len = fr.read(buff)) != -1) {
 		out.print(new String(buff, 0, len));
 	}
 } catch (IOException ex) {
 	out.println("익셉션 발생: " + ex.getMessage());
 }
 %>
 
<!-- 절대 경로를 사용하게 되면 폴더명이 달라질때 예외가 발생한다. -->
</body>
</html>