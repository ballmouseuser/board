<%@page import="java.sql.Date"%>
<%@page import="com.javalec.ex.dao.BDao"%>
<%@page import="com.javalec.ex.dto.BDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String id = (String)session.getAttribute("mid");
	String pw = (String)session.getAttribute("mpassword");
	String name = (String)session.getAttribute("mname");
	Date birthday = (Date)session.getAttribute("mbirthday");
	String phone = (String)session.getAttribute("mphone");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>게시판 구현</title>
</head>
<body>
	<center>
		<div class="container">
			<table class="table table-hover" width="500" cellpadding="0"
				cellspacing="0" border="1">
				<thead>
				<tr>
					<td colspan="5">
					<%
						if(id==null){
							%><a href="login.jsp" class="btn btn-default">로그인</a><%
						}else{
							%><a href="logout.do" class="btn btn-default">로그아웃</a><%
						}
					%>
						
					</td>
				</tr>
				</thead>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>제목</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<%
					BDao dao = new BDao();
					ArrayList<BDto> list = dao.list();
					request.setAttribute("list", list);

					int totalRecordSize = list.size();
					int recordSizePerPage = 5; // 한페이지의 레코드수
					int pageSizePerBlock = 4; // 
					int curBlock = 0; // 시작블럭
					if (request.getAttribute("curBlock") != null) {
						curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
					}
					int curPage = curBlock * pageSizePerBlock; // 커런트 블럭이 바뀌면 자동으로 바뀌게 설정
					if (request.getAttribute("curPage") != null) {
						curPage = Integer.parseInt(request.getAttribute("curPage").toString());
					}
					int beginNum = curPage * recordSizePerPage;

					int pageSize = (int) Math.ceil((double) totalRecordSize / recordSizePerPage);

					for (int i = beginNum; i < beginNum + recordSizePerPage; i++) {
						if (totalRecordSize <= i)
							break;
				%>
				<tr>
					<td><%=list.get(i).getBId()%></td>
					<td><%=list.get(i).getBName()%></td>
					<td><a href="content_view.do?bId=<%=list.get(i).getBId()%>"><%=list.get(i).getBTitle()%></a></td>
					<td><%=list.get(i).getBDate()%></td>
					<td><%=list.get(i).getBHit()%></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="5" align="center">
						<ul class="pagination" style="margin: 0 auto;">
							<%
								if (curBlock > 0) {
							%>
							<li><a href="list.do?curBlock=<%=curBlock - 1%>"><span
									class="glyphicon glyphicon-chevron-left"></span></a></li>
							<%
								} else {
							%>
							<li><span class="glyphicon glyphicon-chevron-left"
								style="color: gray;"></span></li>
							<%
								}
								int startPage = curBlock * pageSizePerBlock;
								int endPage = startPage + pageSizePerBlock;
								for (int i = startPage; i < endPage; i++) {
									if (pageSize <= i)
										break;
							%>
							<li><a href="list.do?curBlock=<%=curBlock%>&curPage=<%=i%>"><%=i%></a></li>
							<%
								}
								if (curBlock < pageSize / pageSizePerBlock) {
							%>
							<li><a href="list.do?curBlock=<%=curBlock + 1%>"><span
									class="glyphicon glyphicon-chevron-right"></span></a></li>
							<%
								} else {
							%>
							<li><span class="glyphicon glyphicon-chevron-right"
								style="color: gray;"></span></li>
							<%
								}
							%>
						</ul>
					</td>
				</tr>
				<tr>
				<%
					if(id==null){
						
					}else{
						%><td colspan="5"><a href="write_view.do" class="btn btn-default">글작성</a></td><%
					}
				%>
					
				</tr>
			</table>
		</div>
	</center>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>