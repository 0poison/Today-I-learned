<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ page
	buffer="8kb"
	autoFlush="false"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버퍼 정보</title>
</head>
<body>
	버퍼크기:<%=out.getBufferSize()%><br> 남은크기:<%=out.getRemaining()%><br>
	auto flush:<%=out.isAutoFlush()%><br>

</body>
</html>