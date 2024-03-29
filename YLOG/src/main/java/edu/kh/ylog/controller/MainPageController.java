package edu.kh.ylog.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.ylog.member.model.dto.Member;
import edu.kh.ylog.member.model.service.MemberService;
import edu.kh.ylog.post.model.dto.Post;
import edu.kh.ylog.post.model.service.PostService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/main")
public class MainPageController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
					
			PostService postService = new PostService(); 
			
			HttpSession session = req.getSession(); 
			
			Member member = (Member) session.getAttribute("loginMember");
			
			List<Post> postList = postService.selectMain();
			
			session.setAttribute("postList", postList);
			
			
					
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
					
			
			} catch (Exception e) {
				System.out.println("[메인 페이지 이동 중 예외 발생]");
				e.printStackTrace();
		}
		
		
	}

}
