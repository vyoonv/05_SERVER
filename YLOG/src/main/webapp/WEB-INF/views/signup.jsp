<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/main.css">
		<title>회원 가입</title>
	</head>
	<body>
		<main>
		
			<h1>회원가입</h1>
			
			<form action="/signup" method="post" class="signup-form" onsubmit="return valdate()">
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
				
				<button id="signup-btn">가입하기</button>
			</form>
		</main>
		
		<c:if test="${not empty sessionScope.message}">
			<script>
				alert('${message}'); 
			</script>
			 
		 <c:remove var="message" scope="session" />
		
		</c:if>
	
		
	
	
	
		<script src="/resources/js/signup.js"></script>
	</body>
</html>