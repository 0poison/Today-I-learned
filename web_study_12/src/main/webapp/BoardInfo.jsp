<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div table {
	width: 600;
	background-color: skyblue;
	border: 1;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<%
	int num = Integer.parseInt(request.getParameter("num").trim());

	//데이터 베이스 접근하여
	BoardDAO bdao = new BoardDAO();
	//BoardBean타입으로 하나의 게시글 가져오기
	BoardBean bean = bdao.getOneBoard(num);
	%>
	<div align="center">
		<h2>게시글 보기</h2>
		<table>
			<tr height="40">
				<td width="100" align="center">글번호</td>
				<td width="100" align="left"><%=bean.getNum()%></td>
				<td width="100" align="center">조회수</td>
				<td width="100" align="center"><%=bean.getReadcount()%></td>
			</tr>
			<tr height="40">
				<td width="100" align="center">작성자</td>
				<td width="180" align="left"><%=bean.getWriter()%></td>
				<td width="120" align="center">작성일</td>
				<td width="180" align="center"><%=bean.getReg_date()%></td>
			</tr>
			<tr height="40">
				<td width="120" align="center">이메일</td>
				<td colspan="3" align="center"><%=bean.getEmail()%></td>
			</tr>
			<tr height="40">
				<td width="120" align="center">제목</td>
				<td colspan="3" align="center"><%=bean.getSubject()%></td>
			</tr>
			<tr height="40">
				<td width="120" align="center">내용</td>
				<td colspan="3" align="center"><%=bean.getContent()%></td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4"><input type="button" value="답글쓰기"
					onclick="location.href='BoardReWriteForm.jsp?num=<%=bean.getNum()%>&ref=<%=bean.getRef()%>&re_step=<%=bean.getRe_step()%>&re_level=<%=bean.getRe_level()%>'"
				> <input type="button" value="수정하기"
					onclick="location.href='BoardUpdateForm.jsp?num=<%=bean.getNum()%>'"
				> <input type="button" value="삭제하기"
					onclick="location.href='BoardDeleteForm.jsp?num=<%=bean.getNum()%>'"
				> <input type="button" value="목록보기"
					onclick="location.href='BoardList.jsp?num=<%=bean.getNum()%>'"
				></td>
		</table>
	</div>
</body>
</html>






