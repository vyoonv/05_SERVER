<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css">
	<title>게시글 조회</title>
	</head>
	<body>
	
		<main>
			<table>
				<tr>
					<td>${post.postTitle}</td>
				</tr>	
				<tr>
					<td>${post.postContent}</td>
				</tr>		
				<tr>
					<td><a class="update-btn">수정</a></td>
					<td><a class="delete-btn">삭제</a></td>
				</tr>
								
				
			</table>
		</main>
	
	</body>
</html>



























