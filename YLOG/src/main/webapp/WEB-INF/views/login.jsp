<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/main.css">
		<title>로그인</title>
	</head>
	<body>
	
		<main>
			<h1>로그인</h1>
	
			<form action="/login" method="post" class="login-form" >
				<div>
					<p>아이디</p>
					<input type="text" name="inputId">
				</div>
				<div>
					<p>비밀번호</p>
					<input type="password" name="inputPw">
				</div>	
				
				<button>로그인</button>
			</form>
		
		</main>
	
	
	
	</body>
</html>