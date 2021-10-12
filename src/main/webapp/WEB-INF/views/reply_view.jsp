<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_reply</title>
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
<h1 align="center">댓글달기</h1>
	<table id="tab" align="center">
		<form action="reply" method="post">
			<input type="hidden" name="bid" value="${reply_view.bid}">
			<input type="hidden" name="bgroup" value="${reply_view.bgroup}">
			<input type="hidden" name="bstep" value="${reply_view.bstep}">
			<input type="hidden" name="bindent" value="${reply_view.bindent}">
			<tr>
				<th>번호</th>
				<td>${reply_view.bid}</td>
			</tr>
			
			<tr>
				<th>조회수</th>
				<td>${reply_view.bhit}</td>
			</tr>
		
			<tr>
				<th>게시자</th>
				<td><input type="text" name="bname" size="50" ></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="btitle" size="50" value="&lt;re&gt; ${reply_view.btitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea  name="bcontent" rows="10" cols="47">&lt;re&gt;${reply_view.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" style="background-color:yellow" value="댓글달기">&nbsp;&nbsp;
				<button type="button" style="background-color:orange" onclick="location.href='list'">목록가기</button>
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