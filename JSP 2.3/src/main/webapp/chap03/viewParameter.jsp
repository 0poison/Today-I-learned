<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page
 language="java"
 contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"
%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <b>request.getParameter() 메서드 사용</b>
 <br> name 파라미터=<%=request.getParameter("name")%><br> address
 파라미터=<%=request.getParameter("address")%><p>
  <b>request.getParameterValues() 메서드 사용</b><br>
  <%
  String[] values = request.getParameterValues("pet");
  if (values != null) {
  	for (int i = 0; i < values.length; i++) {
  %>
  <%=values[i]%>
  <%
  }
  }
  %>
 
 <p>
  <b>request.getParameterNames()메서드 사용</b><br>
  <%
  Enumeration<String> paramEnum = request.getParameterNames();
  while (paramEnum.hasMoreElements()) {
  	String name = (String) paramEnum.nextElement();
  %>
  <%=name%>
  <%
  }
  %>
 
 <p>
  <b>request.getParameterMap()메서드 사용</b><br>
  <%
  Map parameterMap = request.getParameterMap();
  String[] nameParam = (String[]) parameterMap.get("name");
  if (nameParam != null) {
  %>
  name=<%=nameParam[0]%>
  <%
  }
  %>
 
</body>
</html>