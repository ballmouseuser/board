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
				<form action="write.do" method="post">
					<tr>
						<td>이름</td>
						<td><input type="text" class="form-control" name="bName"
							size="50"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" class="form-control" name="bTitle"
							size="50"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea class="form-control" name="bContent" rows="10"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="입력"
							class="btn btn-default">
							&nbsp;&nbsp; <a href="list.do" class="btn btn-default">목록보기</a></td>
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