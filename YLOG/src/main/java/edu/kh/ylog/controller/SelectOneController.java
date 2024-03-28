package edu.kh.ylog.controller;

import java.io.IOException;

import edu.kh.ylog.post.model.dto.Post;
import edu.kh.ylog.post.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/selectone")
public class SelectOneController extends HttpServlet {
	
	
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	try {
		
		
		
		PostService postService = new PostService(); 
		
		HttpSession session = req.getSession(); 
		
		Post post = new Post(); 
		
		post = postService.selectone(req);
		
		session.setAttribute("post", post);
	/*	String referer = req.getHeader("referer");		
		resp.sendRedirect(referer);  */
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	req.getRequestDispatcher("/WEB-INF/views/selectone.jsp").forward(req, resp);
	
}
	
	
	
}
