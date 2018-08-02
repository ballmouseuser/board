<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>회원가입</title>
</head>
<body>
	<center>
		<div class="container">
			<h2>회원가입</h2>
			<form action="join.do" method="post">
				<table width="500" border="1">
					<tr height="50">
						<td width="150" align="center">고객아이디</td>
						<td align="center"><input type="text" name="mid" size="20">
						</td>
					</tr>
					<tr height="50">
						<td width="150" align="center">비밀번호</td>
						<td align="center"><input type="password" name="mpassword"
							size="20"></td>
					</tr>
					<tr height="50">
						<td width="150" align="center">고객이름</td>
						<td align="center"><input type="text" name="mname" size="20">
						</td>
					</tr>
					<tr height="50">
						<td width="150" align="center">생년월일</td>
						<td align="center"><input type="date" name="mbirthday"
							size="20"></td>
					</tr>
					<tr height="50">
						<td width="150" align="center">전화번호</td>
						<td align="center"><input type="tel" name="mphone" size="20">
						</td>
					</tr>
					<tr height="50">
						<td colspan="2" align="center"><input type="submit"
							value="회원가입" class="btn btn-default"></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>