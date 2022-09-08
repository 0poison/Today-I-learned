<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 관리</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/shopping.css">

</head>
<body>
	<div id="wrap" align="center">
		<h1>영화 리스트-관리자 페이지</h1>
		<table class="list">
			<tr>
				<td colspan="6" style="border: white; text-align: right"><a href="moviewrite.do">정보 등록</a>
					<!-- 링크 걸면 get방식 --></td>
			</tr>
			<tr>
				<th>제목</th>
				<th>감독</th>
				<th>배우</th>
				<th>가격</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="movie" items="${mlist}">
				<tr class="record">
					<td><a href="${pageContext.request.contextPath}/movieinfo.do?code=">${movie.title}</a></td>
					<td>${movie.director}</td>
					<td>${movie.actor}</td>
					<td style="text-align: right">${movie.price}원</td>
					<td><a href="${pageContext.request.contextPath}/movieupdate.do?code=${movie.code}">정보
							수정</a></td>
					<td><a href="${pageContext.request.contextPath}/moviedelete.do?code=${movie.code}">정보
							삭제</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>