<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/resources/css/main.css">
		<title>YLOG</title>
	</head>
	<body>
		<main>
		
			<c:choose>
				<%-- 메인페이지/로그인 전/로그인/회원가입버튼만 보이게 --%>
				<c:when test="${empty sessionScope.loginMember}">
				
				<h1>YLOG</h1>
				
				<form class="main-form">
					<a href="/login" class="login">로그인</a>
					<a href="/signup" class="signup">회원가입</a>					
				</form>				
				</c:when>

 			<c:otherwise>
 			
 			
 			
				<c:choose>
					<%-- 포스트가 없다면 --%>
					<c:when test="${empty postList}">
						<button href="/insert">새 포스트</button>
					</c:when>
					
					<c:otherwise>
						<div class="postboard">
							<c:forEach var="post" items="${postList}">
								<div class="eachpost">
									<div id="posttitle" onclick="location.href='/selectone'">${post.postTitle}</div>
							</div>
							</c:forEach>
						</div>
					</c:otherwise>
			</c:choose>	
			
			<div class="button-div">
				<a href="/insert">새 포스트</a>
				<a>로그아웃</a>
			</div>
			
							
			</c:otherwise>
		</c:choose> 	
		
		</main>
		
		
			<%-- session에 message가 존재할 경우 --%>
		<%-- not empty : 비어있지 않을 경우 true --%>
		<c:if test="${not empty sessionScope.message}">
			<script>
				// EL/JSTL 구문이 자바스크립트 보다 먼저 해석되는데 
				// 문자열이 들어가 있는 데이터의 경우 
				// 따옴표가 없는 상태라 붙여줘야 함 
				alert('${message}'); 
			</script>
			
			<%-- 
				session에 message를 추가하면 
				브라우저 종료 또는 만료 전까지 계속 메시지가 출력됨 
				-> 1회 출력 후 session에서 message 삭제 
			 --%>
			 
			 <c:remove var="message" scope="session" />
		
		</c:if>
		
		
		
	</body>
</html>