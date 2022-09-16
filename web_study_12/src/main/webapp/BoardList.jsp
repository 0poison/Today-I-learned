<%@page import="model.BoardBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div table {
	width: 700;
	border: 1px solid #444444;
	background-color: skyblue;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
	<div align="center">
		<h2>전체 게시글 보기</h2>
		<%
		//한 페이지에 보여질 게시글 개수
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		//만약 처음이다
		if (pageNum == null) {
			pageNum = "1";
		}
		int count = 0;
		int number = 0; //페이지 넘버링

		//현재 보고자 하는 페이지 숫자를 지정
		int currentPage = Integer.parseInt(pageNum);
		BoardDAO bdao = new BoardDAO();

		//전체게시글의 개수
		count = bdao.getAllCount();

		//현재 페이지에 보여줄 시작 번호를 설정
		int startRow = currentPage * pageSize - (pageSize - 1);
		int endRow = currentPage * pageSize;

		Vector<BoardBean> vec = bdao.getAllBoard(startRow, endRow);
		number = count - (currentPage - 1) * pageSize;
		//count=29이면 currentPage=3 pageSize=10 number는 9로 계산
		%>
		<table>
			<tr height="40">
				<td align="right" colspan="5"><input type="button" value="글쓰기"
					onclick="location.href='BoardWriteForm.jsp'"
				></td>
			</tr>
			<tr height="40">
				<td width="50" align="center">번호</td>
				<td width="320" align="center">제목</td>
				<td width="100" align="center">작성자</td>
				<td width="150" align="center">작성일</td>
				<td width="80" align="center">조회수</td>
			</tr>
			<%
			for (int i = 0; i < vec.size(); i++) {
				BoardBean bean = vec.get(i); //같은 타입이어야 한다.
			%>
			<tr height="40">
				<td width="50" align="center"><%=number--%></td>
				<td width="320" align="left"><a href="BoardInfo.jsp?num=<%=bean.getNum()%>"
					style="text-decoration: none;"
				> <%
 if (bean.getRe_step() > 1) {
 	for (int j = 0; j < (bean.getRe_step() - 1) * 5; j++) {
 %> &nbsp; <!--  Re_step의 수만큼 공백이 늘어남 --> <%
 }
 }
 %> <%=bean.getSubject()%>
				</a></td>
				<td width="100" align="center"><%=bean.getWriter()%></td>
				<td width="150" align="center"><%=bean.getReg_date()%></td>
				<td width="80" align="center"><%=bean.getReadcount()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<p>
			<%
			int pageCount = 0;
			int startPage = 0;
			if (count > 0) {
				pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
				// 필요한 페이지 수
				startPage = 1;
				if (currentPage % pageSize != 0) {
					startPage = (currentPage / 10) * 10 + 1;
				} else {
					startPage = currentPage - 9;
				}
				int pageBlock = 10;
				int endPage = startPage + pageBlock - 1;
				if (endPage > pageCount)
					//마지막 페이지 설정
					endPage = pageCount;
				if (startPage > 10) {
			%>
			<a href="BoardList.jsp?pageNum=<%=startPage - 10%>"><[이전]</a>
			<%
			}
			for (int i = startPage; i <= endPage; i++) {
			%>
			<a href="BoardList.jsp?pageNum=<%=i%>">[<%=i%>]
			</a>
			<%
			}
			if (endPage < pageCount) {
			%>
			<a href="BoardList.jsp?pageNum=<%=startPage + 10%>">[다음]></a>
			<%
			}
			}
			%>
		</p>
	</div>
</body>
</html>