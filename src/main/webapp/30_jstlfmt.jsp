<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%><%--core를 fmt c를 fmt로 바꿔야 한다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:formatNumber value="1234567.89"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="1234567.89" groupingUsed="false"></fmt:formatNumber>
	${value}
	<br>
	<%--순수하게 숫자만 필요하다면 false를 입력해야 그냥 순수하게 나오고 true라던가 그냥 입력 하게 되면 ,가 찍히게 된다. --%>
	<fmt:formatNumber value="0.5" type="percent"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="10000" type="currency" currencySymbol="$"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="1234567.8912345" pattern="###,###.##"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="1234567.89" pattern=".000"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="123.89" pattern="00000.###"></fmt:formatNumber>
	<br>
	<fmt:formatNumber value="456.89" pattern="##.#"></fmt:formatNumber>
	<%--한자리는 반올림 된다. --%>
	<br>
	<fmt:formatNumber value="123456.89" pattern="#############.###"></fmt:formatNumber>
	<br>
</body>
</html>