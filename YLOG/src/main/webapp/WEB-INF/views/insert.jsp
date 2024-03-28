<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>New Post</title>
	<link rel="stylesheet" href="/resources/css/main.css">
	</head>
	<body>
		
		<main>
		
			<h1>New Post</h1>
			
			<form action="/insert" method="post">
				<p>제목</p>
				<input type="text" name="postTitle" required>
				
				<p>내용</p>
				<textarea name="postContent" 
				style="resize:none; font-size:18px;" cols="30" rows="10"></textarea>
				
				<br>
				<button class="insert-btn">등록</button>
			
			</form>
			
			
		
		</main>
		
	
	</body>
</html>