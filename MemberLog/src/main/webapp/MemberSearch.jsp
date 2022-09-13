<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 찾기</title>
<style>
div {
	text-align: center;
}
</style>
</head>
<body>
	<div>
		<h1>회원 찾기</h1>
		<form action="FindMember.jsp">
			<table>
				<tr>
					<td><input type="text" name="id" size="40" placeholder="찾을 id를 넣으세요"></td>
				</tr>
			</table>
			<input type="submit" value="회원찾기"> <input type="reset" value="취소">
		</form>
	</div>
</body>
</html>