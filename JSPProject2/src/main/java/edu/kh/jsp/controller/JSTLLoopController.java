package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.model.dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/jstl/loop")
public class JSTLLoopController extends HttpServlet{

	// a 태그 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Book> bookList = new ArrayList<Book>(); 
		
		bookList.add(new Book("자바의 정석", "남궁성", 15000)); 
		bookList.add(new Book("불변의 법칙", "모건 하우절", 12000)); 
		bookList.add(new Book("무엇이 나를 행복하게 만드는가", "리처드 J", 10000)); 
		bookList.add(new Book("알사탕 제조법", "백희나", 9000)); 
		
		req.setAttribute("bookList", bookList);
		
		
		req.getRequestDispatcher("/WEB-INF/views/jstl/loop.jsp").forward(req, resp);

	}
	
	
}
