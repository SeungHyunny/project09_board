<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_content</title>
<style>
	#tab{
		width:40%;
		cellpadding:0;
		cellspacing:0;
		border: 2px solid;
		border-collapse: collapse;
		border-color:yellow;
		align:center;
		text-align:center;
	}
	th, td {
	    padding: 10px;
	    text-align:center;
	}
</style>
</head>
<body>
<h1 align="center">게시글상세보기</h1>
<table id="tab" align="center">
	<form action = "modify" method="post">
		<input type="hidden" name="bid" value="${content_view.bid}">
		<tr>
			<th>번호</th>
			<td>${content_view.bid}</td>
		</tr>
		
		<tr>
			<th>조회수</th>
			<td>${content_view.bhit}</td>
		</tr>
	
		<tr>
			<th>게시자</th>
			<td><input type="text" name="bname" size="50" value="${content_view.bname}"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="btitle" size="50" value="${content_view.btitle }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea  name="bcontent" rows="10" cols="47">${content_view.bcontent}</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input style="background-color:pink" type="submit" value="수정"> &nbsp;&nbsp;
			<button type="button" style="background-color:orange" onclick="location.href='list'">목록가기</button>&nbsp;&nbsp;
			<button type="button" style="background-color:yellow" onclick="location.href='reply_view?bid=${content_view.bid}'">댓글달기</button>
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