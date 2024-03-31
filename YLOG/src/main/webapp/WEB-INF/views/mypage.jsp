<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>My Page</title>
	</head>
	<body>
	
		<h1>마이페이지</h1>
		
		<a href="/updateMember?memNo=${session.loginMember.memNo}">내 정보 수정</a>
		<button>회원 탈퇴</button>
	
	</body>
</html>