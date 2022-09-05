<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customjoin</title>
</head>
<body>
	<form
		action="custom.do"
		method="post"
	>
		<table
			align="center"
			width="550"
		>
			<tr>
				<td
					colspan="2"
					align="center"
				>사원 등록</td>
			</tr>
			<tr>
				<td align="center">아이디</td>
				<td><input
					type="text"
					name="id"
				></td>
			</tr>
			<tr>
				<td align="center">비밀 번호</td>
				<td><input
					type="password"
					name="pwd"
				></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input
					type="text"
					name="name"
				></td>
			</tr>
			<tr>
				<td align="center">권한</td>
				<td><select name="lev">
						<option value="A">운영자</option>
						<option value="B">일반 회원</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">성별</td>
				<td><select name="gender">
						<option value="1">남자</option>
						<option value="2">여자</option>
				</select></td>
			</tr>
			<tr>
				<td align="center">전화 번호</td>
				<td colspan="3"><input
					type="text"
					name="phone"
				></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input
					type="submit"
					value="등록"
				> <input
					type="reset"
					value="취소"
				> <input
					type="button"
					value="메인 페이지 이동"
					onclick="location.href='main.jsp'"
				>
		</table>
	</form>
</body>
</html>