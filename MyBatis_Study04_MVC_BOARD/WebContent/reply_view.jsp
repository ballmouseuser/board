<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="reply.do" method="post">
					<input type="hidden" name="bId" value="${reply_view.BId}">
					<input type="hidden" name="bGroup" value="${reply_view.BGroup}">
					<input type="hidden" name="bStep" value="${reply_view.BStep}">
					<input type="hidden" name="bIndent" value="${reply_view.BIndent}">
					<tr>
						<td>번호</td>
						<td>${reply_view.BId}</td>
					</tr>
					<tr>
						<td>히트</td>
						<td>${reply_view.BHit}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" class="form-control" name="bName"
							value="${reply_view.BName}"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" class="form-control" name="bTitle"
							value="${reply_view.BTitle}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" rows="10" name="bContent">${reply_view.BContent}</textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-default" value="답변">
						<a href="list.do" class="btn btn-default">목록</a></td>
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