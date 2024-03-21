package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet ("/gimbapHeaven")
public class GimbapController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderer = req.getParameter("orderN"); 
		String gimbap = req.getParameter("gimbap"); 
		String bs = req.getParameter("bs"); 
		String menu = req.getParameter("menu"); 
		
		System.out.println(orderer);
		System.out.println(gimbap);
		System.out.println(bs);
		System.out.println(menu);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/gimbap.jsp"); 
		
		dispatcher.forward(req, resp); 
		
		
	}
	
	

}
