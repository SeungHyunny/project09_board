<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
<style>

	#tab{
		width:30%;
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
<h1 align="center">회원가입을 축하합니다~</h1>
	<table id="tab" align="center">
			<tr>
				<td colspan="2">회원가입을 다시하려면 '회원가입 다시하기'버튼을!<br>게시판을 보려면 '로그인' 버튼을 눌러주세요!</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" style="background-color:pink" onclick="location.href='join_view'">회원가입 다시하기</button> &nbsp;&nbsp;
					<button type="button" style="background-color:orange" onclick="location.href='list'">목록보기</button>
				</td>
			</tr>
	</table>
		<hr>
	<div align="center">
	<img src="./resources/img/img2.jpg">
		<h3>사과파는 짱구</h3>
		(2021.09.27 ~ )
	</div>
</body>
</html>