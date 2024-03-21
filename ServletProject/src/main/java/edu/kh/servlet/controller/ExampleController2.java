package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Servlet 관련 코드를 작성하기 위해서는 HttpServlet 클래스 상속 받아야 함 

/* @Override
 * 어노테이션 : 컴파일러가 읽는 주석 
 * 
 * @WebServlet 어노테이션 
 * -> 해당 클래스를 Servlet으로 등록하고 
 * 	  매핑할 주소를 연결하라고 지시하는 어노테이션 
 * 
 * -> 서버 실행시 자동으로 web.xml에 
 * <serblet><servlet-mapping>을 작성하는 효과 
 * */

@WebServlet("/signUp")
public class ExampleController2 extends HttpServlet {

	
	/** POST 요청 처리 메서드 오버라이딩 
	 *
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 원래 tomcat9 버전에는 전달받은 값을 얻어와서 확인할 때 한글이 깨지는 문제 발생
		// 해결방법 : 전달받은 데이터의 문자인코딩을 서버에 맞게 변경
		// req.setCharacterEncodeing("UTF-8")
		// -> tomcat10버전 이상부터 자동 인코딩 처리를 해주기 때문에 추가적인 처리 필요 없음 
		
		String inputId = req.getParameter("inputId");
		String inputPw = req.getParameter("inputPw"); 
		String inputName = req.getParameter("inputName"); 
		String intro = req.getParameter("intro");
		
		System.out.println(inputId);
		System.out.println(inputPw);
		System.out.println(inputName);
		System.out.println(intro);
		
		// 응답화면 만들기 
		// -> Java 에서 작성하기 힘들다
		// -> JSP가 대신 화면을 만들기 / Servlet이 JSP에게 요청 위임
		
		// JSP가 대신 화면을 만들어주기 위해서
		// Servlet이 어떤 요청을 받았는지 알아야 함
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result.jsp"); //webapp폴더 기준 
		
		dispatcher.forward(req, resp); // ** forward ** 중요~! **위임**
		
		
		
		
		
	}
	
	
	
	
}
