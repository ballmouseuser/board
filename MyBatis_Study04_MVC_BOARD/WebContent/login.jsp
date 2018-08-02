<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>로그인</title>
</head>
<body>
	<center>
		<h2>로그인</h2>
		<form action="login.do" method="post">
			<table width="500" border="1">
				<tr height="50">
					<td width="150" align="center">고객아이디</td>
					<td align="center"><input type="text" name="mid" size="20">
					</td>
				</tr>
				<tr height="50">
					<td width="150" align="center">비밀번호</td>
					<td align="center"><input type="password" name="mpassword" size="20">
					</td>
				</tr>
				<tr height="50">
					<td colspan="2" align="center"><input type="submit" value="로그인" class="btn btn-default">
					<a href="join.jsp" class="btn btn-default">회원가입</a>
					</td>
				</tr>
			</table>
		</form>
	</center>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>