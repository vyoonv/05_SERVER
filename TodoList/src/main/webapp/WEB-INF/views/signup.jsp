<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 가입</title>
		<link rel="stylesheet" href="/resources/css/main.css">
	</head>
	<body>
		<main>
			<h1>회원가입</h1>
			
			<form action="/signup" method="post" class="signup-form" onsubmit="return validate()">
				<p>아이디</p>
				<input type="text" name="inputId" id="inputId" autocomplete="off" required>
				<span id="idMsg">영어 소문자, 숫자 특수문자(-_)포함 6~14글자</span>
				
				<p>비밀번호</p>
				<input type="password" name="inputPw" id="inputPw" required>
				
				<p>비밀번호 확인</p>
				<input type="password" name="inputPw2" id="inputPw2" required>
				<span id="pwMessage"></span>
				
				<p>닉네임</p>
				<input type="text" name="inputName" id="inputName" required>
				<span id="nameMessage"></span>
				<br>
				
				<button>가입하기</button>
				
			</form>
		</main>
		
		
		<%-- 해당 jsp파일에서 사용할 javascript 코드가 작성된 js 파일 연결하기 --%>
		<script src="/resources/js/signup.js"></script>
	</body>
</html>