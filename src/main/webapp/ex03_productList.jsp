<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="*" method="post">
		<jsp:useBean id="product" class="com.saeyan.javabeans.Product" />
		<select>
			<%-- <%
			for (String item : product.getProductList()) {
				out.println("<option>" + item + "</option>");
			}
			%>
 --%>
			<c:forEach var="item" items="${product.productList}">
				<option>${item}</option>
			</c:forEach>
		</select> <input type='submit' value="선택">
	</form>
</body>
</html>