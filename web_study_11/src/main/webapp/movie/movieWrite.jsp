<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>정보 등록</h1>
		<form action="${pageContext.request.contextPath}/moviewrite.do" method="post"
			enctype="multipart/form-data" name="frm"
		>
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" size="60"></td>
				</tr>
				<tr>
					<th>가격</th>
					<td><input type="text" name="price" size="60">원</td>
				</tr>
				<tr>
					<th>감독</th>
					<td><input type="text" name="director" size="60"></td>
				</tr>
				<tr>
					<th>배우</th>
					<td><input type="text" name="actor" size="60"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="poster"></td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea cols="70" rows="10" name="synopsis"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="확인" onclick="return productCheck()"> <input type="reset"
				value="취소"
			> <input type="button" value="목록" onclick="location.href='movielist.do'">
		</form>
	</div>
</body>
</html>