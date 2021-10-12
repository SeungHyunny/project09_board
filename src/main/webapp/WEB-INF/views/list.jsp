<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.vision.mybatis_board.dto.*" %>   
<%@ page import = "com.vision.mybatis_board.dao.*" %>
<%@ page import = "com.vision.mybatis_board.service.*" %> 
<%@ page import = "java.util.*" %> 
<%
	// 페이징 처리를 위한 작업
	String pageNumberStr = request.getParameter("xpage"); 
	BListService service = new BListService();
	int pageNumber = 1; 
	if(pageNumberStr != null){
		pageNumber = Integer.parseInt(pageNumberStr);
	}
	MessageListView viewData = service.getMessageListView(pageNumber);
	int totalPages = viewData.getPageTotalCount();
	if(pageNumberStr==null) pageNumberStr="1";
	
	out.println(pageNumberStr +"/"+ totalPages);
	List<BDto> subList = viewData.getMessageList();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board_list</title>
<style>
	#tab{
		width:60%;
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
<h1 align="center">자유게시판</h1>
	<table id="tab" align="center">
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Title</th>
			<th>Date</th>
			<th>Hit</th>
		</tr>
		<!-- Model.setAttribute("list",dtos)로 서비스에서 등록한 내용을 읽어 뿌려준다. -->
		
		<c:forEach items="<%=subList %>" var="dto">
		<tr>
			<td>${dto.bid}</td>
			<td>${dto.bname}</td>
			<td>
				<c:forEach begin="1" end="${dto.bindent}">re></c:forEach>
				<a href="content_view?bId=${dto.bid}">${dto.btitle}</a></td>
			<td>${dto.bdate}</td>
			<td>${dto.bhit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><button type="button" style="background-color:yellow" onclick="location.href='write_view'">글작성</button></td>
		</tr>
	</table>
	<br/>
	<div align="center">
	<%
		for (int i = 1; i <= viewData.getPageTotalCount(); i++) {
	 %>
		<a href="list?xpage=<%=i%>">[<%=i%>]</a>
	<%
		}
	%>
	<hr>
	
	<h3>사과파는 짱구</h3>
	(2021.09.27 ~ )
	</div>
</body>
</html>