<%@ page
 language="java"
 contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
 main.jsp에서 생성한 내용

 <jsp:include
  page="sub.jsp"
  flush="false"
 />
 include 이후의 내용
</body>
</html>