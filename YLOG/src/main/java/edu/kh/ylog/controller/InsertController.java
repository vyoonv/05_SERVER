package edu.kh.ylog.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.ylog.member.model.dto.Member;
import edu.kh.ylog.post.model.dto.Post;
import edu.kh.ylog.post.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/insert")
public class InsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession(); 
			
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			
			Member member = (Member)session.getAttribute("loginMember"); 
			
			PostService postService = new PostService(); 
			
			int result = postService.insert(postTitle, postContent, member.getMemNo()); 
			
			if(result > 0) {
				session.setAttribute("message", "업로드 성공!");
				
				List<Post> postList = postService.selectAll(member.getMemNo()); 
				session.setAttribute("postList", postList);
				
				resp.sendRedirect("/");
				
				
			} else {
				
				session.setAttribute("message", "업로드 실패!"); 
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
		} catch(Exception e) {
			System.out.println("[post 업로드 중 예외 발생]");
			e.printStackTrace();
			
		}
		
		
		
		
	}
	
	
	
	

}
