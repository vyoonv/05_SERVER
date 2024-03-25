<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL 조건문</title>
	</head>
	<body>
		
		<h1>4. 조건문 - if (c:if)</h1>
		
		<pre>
			- 단독 if문(c:else 없음)
			- 속성은 test만 존재
			
			**주의사항**
			1) test의 속성값은 무조건 EL 구문으로 작성해야 함 
			2) test의 속성값은 true 또는 false가 나오는 조건식이어야한다 
			3) test의 속성값을 작성하는 "" 내부에는 앞뒤 공백이 존재하면 안됨 
			
		</pre>
		
		<c:if test="${money==50000}" >
			<h3 style="color :gold">돈이 5만원 있습니다</h3>
		</c:if>
		
		<h3>EL 에서 모든 비교는 == 또는 eq /!= 또는 ne(not equals)</h3>
		<h3>EL에서 문자열은 ' '(홑따옴표)로 표현 </h3>
		
		<c:if test = "${name eq'홍길동'}">
			<h3>이름이 일치합니다</h3>
		</c:if>
		
		<c:if test="${name ne '홍길동'}">
			<h3>이름이 일치하지 않습니다</h3>
		</c:if>
		
		<hr>
		
		<h1>5. 조건문 - choose, when, otherwise (if ~ else if ~ else)</h1>
		
		<pre>
			choose : when, otherwise 태그를 감싸는 태그 
					(이 안에 if~else if~else 를 씀)
					
			when : if, else if(역할의 태그)
					속성은 test 밖에 없음
					 
			otherwise : else 역할, 속성 X
			
			<%-- 
				lt (little) : < '미만'
				gt (greater) : > '초과'
				
				le (little or equal) : <= '이하'
				ge (greater or equal) : >= '이상' 
			
			 --%> 							
		</pre>
		
		<!-- XML/HTML 용 주석 -->
		
		<c:choose>
			
			<%-- choose문 안에 주석 작성할 때 반드시 JSP용 주석으로 작성 --%>
			<c:when test="${param.val gt 100}">
				100 초과 
			</c:when>
			<c:when test="${param.val < 100}">
				100 미만 
			</c:when>
			<c:otherwise>
				100과 같다 
			</c:otherwise>
			
		</c:choose>
		
		
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>