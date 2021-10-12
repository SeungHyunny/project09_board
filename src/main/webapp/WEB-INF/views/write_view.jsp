<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_write</title>
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
<h1 align="center">게시글입력</h1>
	<table id="tab" align="center">
		<form action = "write" method="post">
			<tr>
				<th>게시자</th>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea  name="bcontent" rows="10" cols="47"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" style="background-color:yellow" value="입력하기"> &nbsp;&nbsp;
					<button type="button" style="background-color:orange" onclick="location.href='list'">목록가기</button>
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