<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>board_join</title>
<style>
	#tab{
		width:40%;
		cellpadding:0;
		cellspacing:0;
		border: 2px solid;
		border-collapse: collapse;
		border-color:yellow;
	}
	th, td {
	    padding: 10px;
	    text-align:center;
	}
</style>
</head>
<body>
<h1 align="center">회원가입하기</h1>

	<table id="tab" align="center">
		<form action = "join" method="post">
			<tr>
				<th>id</th>
				<td><input type="text" name="id" size="50"></td>
			</tr>
			<tr>
				<th>pw</th>
				<td><input type="text" name="pw" size="50"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="50"></td>
			</tr>
			<tr>
				<th>핸드폰번호</th>
				<td><input type="text" name="phone" size="50"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" style="background-color:yellow" value="회원가입하기"> &nbsp;&nbsp;
				</td>
			</tr>
		</form>
	</table>
	<hr>
	
	<div align="center">
		<h3>사과파는 짱구</h3>
		(2021.09.27 ~ )
	</div>

</body>
</html>