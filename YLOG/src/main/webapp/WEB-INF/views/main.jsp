<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<link rel="stylesheet" href="/resources/css/main.css">
	</head>
	<body>
	<main>
	<c:choose>
		<c:when test="${empty post.postList}">
			<h1>새로운 포스트를 등록해보세요</h1>
			<div class="buttons">
			<a href="/insert" id="newpost-btn">새 포스트</a>
			<a href="/logout" id="logout-btn">로그아웃</a>
			</div>		
		</c:when>	
		<c:otherwise>			
			<div class="postboard">
				<c:forEach var="post" items="${postList}">
						<div class="eachpost">
							<input name="postNo" type="hidden" value="${post.postNo}">
							<div id="postTitle">${post.postTitle}</div>
							<div id="postContent">${post.postContent}</div>
							<br>						
						</div>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
	
		<c:if test="${not empty sessionScope.message}">
			<script>
				alert('${message}'); 
			</script>
			 
		 <c:remove var="message" scope="session" />
		
		</c:if>
		
		</main>
		
	</body>
</html>