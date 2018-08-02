<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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
<title>Insert title here</title>
</head>
<body>
	<center>
		<div class="container">
			<table class="table table-hover" width="500" cellpadding="0" cellspacing="0" border="1">
				<form action="modify.do" method="post">
					<input type="hidden" name="bId" value="${content_view.BId}">
				<tr>
					<td>번호</td>
					<td>${content_view.BId}</td>
				</tr>
				<tr>
					<td>히트</td>
					<td>${content_view.BHit}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" class="form-control" name="bName"
						value="${content_view.BName}"></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" class="form-control" name="bTitle"
						value="${content_view.BTitle}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea class="form-control" rows="10" name="bContent">${content_view.BContent}</textarea></td>
				</tr>
				<tr>
				<%
					if(id==null){
						%>
						<td colspan="2"><a href="list.do" class="btn btn-default">목록보기</a></td>
						<%
					}else{
						%>
							<td colspan="2"><input type="submit" class="btn btn-default" value="수정"> &nbsp;&nbsp;
							<a href="delete.do?bId=${content_view.BId} " class="btn btn-default">삭제</a>	&nbsp;&nbsp;
							<a href="reply_view.do?bId=${content_view.BId}"	class="btn btn-default">답변</a> &nbsp;&nbsp;
							<a href="list.do" class="btn btn-default">목록보기</a></td>
						<%
					}
				%>
				</tr>
				</form>
			</table>
		</div>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>