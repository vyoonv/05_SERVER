<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/main.css">
		<title>Post 수정</title>
	</head>
	<body>
	
		<main>
			<h1>수정하기</h1>

			<form action="/update" method="post">
				<p>제목</p>
				<input type="text" name="postTitle" value="${post.postTitle}" required>
				<br><br>
				
				<p>내용</p>
				<textarea name="postContent" style="resize: none; 
					font-size: 18px;" cols="30" rows="10">${post.postContent}</textarea>
				
				<input name="postNo" value="${post.postNo}" type="hidden">
				
				<br>
				<button class="insert-btn">수정하기</button>
			</form>
		</main>
	
	<c:if test="${not empty sessionScope.message}">
			<script>
				alert('${message}'); 
			</script>
			 
		 <c:remove var="message" scope="session" />
		
		</c:if>    
	</body>
</html>