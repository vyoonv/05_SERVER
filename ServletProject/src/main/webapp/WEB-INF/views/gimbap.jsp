<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title><%= request.getParameter("orderN") %>님의 주문 결과</title>
	</head>
	<body>
		<h3>주문자 : <%= request.getParameter("orderN") %></h3>
		
		<h3>주문한 메뉴 : 
			<%= request.getParameter("gimbap") %>
			<%= request.getParameter("bs") %>
			<%= request.getParameter("menu") %>
		</h3>	
	
	</body>
</html>