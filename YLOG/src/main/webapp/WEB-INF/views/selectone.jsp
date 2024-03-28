<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>     
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css">
	<title>게시글 조회</title>
	</head>
	<body>
	
		<main>
			<div>
			
			<div><%= request.getAttribute("post") %></div>
			
			<span>${post.postContent}</span>

			</div>
					<a class="update-btn">수정</a>
					<a class="delete-btn">삭제</a>
				
		</main>
	
	</body>
</html>




























