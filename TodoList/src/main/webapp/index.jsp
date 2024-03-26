<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>     
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<!-- css,js 파일 연결할 때 webapp 폴더 기준 -->
		<link rel="stylesheet" href="/resources/css/main.css">
		
		<title>To do List</title>
	</head>
	<body>
		<main>
			<c:choose>
				<%-- 로그인을 하지 않았다면 : 로그인/회원가입 입력 폼 출력 --%>	
				<c:when test="${empty sessionScope.loginMember}">
				
				<h1>투 두 리스트 로그인</h1>
				
				<form action="/login" method="post" class="login-form">
					<div>
						<p>아이디</p>
						<input type="text" name="inputId">
					</div>
					<div>
						<p>패스워드</p>
						<input type="password" name="inputPw">
					</div>

					<button>로그인</button>
				</form>
				</c:when>
				
				<%-- 로그인을 했다면 : 현재 로그인한 사람의 todoList 출력 --%>	
				<c:otherwise>
					
					<h1>${sessionScope.loginMember.memberNickname}의 TO DO List</h1>
					
					<c:choose>
						<%-- 투두 리스트가 없다면 --%>
						<c:when test="${empty todoList}">
							<h2>할 일이 하나도 없네요!</h2>
						</c:when>	
						
						<%-- 투두 리스트가 있다면 --%>	
						<c:otherwise>
							<table>
								<c:forEach var="todo" items="${todoList}">
									<tr>
										<td>${todo.todoTitle}</td>
										<td>(${todo.todoMemo})</td>
										<td>${todo.todoDate}</td>
										<td><a class="update-btn">수정</a></td>
										<td><a class="delete-btn">삭제</a></td>
										
									</tr>
								</c:forEach>								
							</table>
						</c:otherwise>
					</c:choose>
					
					
					<div class="button-div">
						<a class="insert-btn">등록하기</a>
						<a href="/logout" class="logout-btn">로그아웃</a>
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