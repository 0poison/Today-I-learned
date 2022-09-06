<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style type="text/css">
td {
	border: 1px solid black;
	width: 200px;
	text-align: center;
}

table.mainmenu td.login:hover {
	background-color: pink;
}
</style>
</head>
<body>
	<table
		class="mainmenu"
		align="center"
	>
		<c:if test="${empty loginUser}">
			<tr>
				<td>${loginUser.name}님반갑습니다.</td>
				<td></td>
				<td class="login"><a
					name="login"
					href="login.do"
					style="text-decoration: none;"
				>로그인</a></td>
				<!-- 링크를 연결하는 것은 GET방식 -->
				<td style="width: 250px">사원 등록<br> <span style="color: red">(관리자로 로그인 후 사용가능)</span></td>
				<td>마이페이지<br> <span style="color: red">(로그인 후 사용가능)</span></td>
			</tr>
		</c:if>
		<c:if test="${!empty loginUser}">
			<tr>
				<td>${loginUser.name}님반갑습니다.</td>
				<td>레벨: ${loginUser.lev }</td>
				<td class="login"><a
					name="login"
					href="logout.do"
					style="text-decoration: none;"
				>로그아웃</a></td>
				<c:choose>
					<c:when test="${result==2}">
						<td class="login"><a
							href="custom.do"
							style="text-decoration: none;"
						>사원 등록</a></td>
					</c:when>
					<c:when test="${result==3 }">
						<td style="width: 300px"><br> <span style="color: red">(관리자로 로그인 후 사용가능)</span>
					</c:when>
				</c:choose>
				<td class="login"><a
					href="mypage.do"
					style="text-decoration: none;"
				>마이페이지</a></td>
			</tr>
		</c:if>
	</table>

</body>
</html>
