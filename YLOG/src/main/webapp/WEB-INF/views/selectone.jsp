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
			<%
				session.getAttribute("postTitle"); 
			%>
		
			
	
		</main>
	
	</body>
</html>




<%--

	<c:choose>
				
				<c:when test="${post.memNo == sessionScope.loginMember.memNo}">
					<table>
					<tr>
						<td>${post.postTitle}</td>
						<td>${post.postContent}</td>
						<td><a class="update-btn">수정</a></td>
						<td><a class="delete-btn">삭제</a></td>
					</tr>	
					</table>
					
				</c:when>
			
			
			
			</c:choose>

 --%>



















