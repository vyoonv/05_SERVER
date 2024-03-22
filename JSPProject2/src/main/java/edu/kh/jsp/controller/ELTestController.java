package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/elTest")
public class ELTestController extends HttpServlet{

	
	/**
	 *  a태그 요청 (get방식)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/elTest.jsp");
		
		dispatcher.forward(req, resp); 
		
		
	}
	
	/**
	 * elTest.jsp에서 요청 온 form태그 요청 (post방식) 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 새로운 값을 req에 세팅 
		req.setAttribute("address", "서울시 중구 남대문로 120");
		req.setAttribute("score", 100);
		
		List<String> strList = new ArrayList<String>(); 
		strList.add("가나다");
		strList.add("라마바");
		strList.add("사아자");
		
		req.setAttribute("strList", strList);
		
		// Book 객체 Attribute 세팅
		Book book = new Book("어린왕자", "생택쥐베리", 4000); 
		
		req.setAttribute("book", book);
		
		
		// null과 비어있다
		List<String> list1 = null; // null // 참조할 주소 없음 
		List<String> list2 = new ArrayList<String>(); // 비어있음 (heap영역에 ArrayList 생성되어있음)
		
		req.setAttribute("list1", list1); 
		req.setAttribute("list2", list2); 
		
		
		// 요청 위임 
		RequestDispatcher dis = req.getRequestDispatcher("/WEB-INF/views/el/elResult.jsp");
		
		dis.forward(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
}
