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


@WebServlet("/update")
public class UpdateController extends HttpServlet{
	
	private PostService postService = new PostService(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			
			Post post = postService.selectOne(req.getParameter("postNo"), member.getMemNo());
			
			req.setAttribute("post", post);
			
			req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
			
			
		} catch(Exception e) {
			System.out.println("[post 조회 중 예외발생]");
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			HttpSession session = req.getSession();
			
			Member member = (Member) session.getAttribute("loginMember");
			String postTitle = req.getParameter("postTitle");
			String postContent = req.getParameter("postContent");
			String postNo = req.getParameter("postNo");
			
			int result = postService.update(postTitle, postContent, member.getMemNo(), postNo);
			
			if(result > 0) {
				
				session.setAttribute("message", "수정 되었습니다!");
	
				List<Post> postList = postService.selectAll(member.getMemNo());
				session.setAttribute("postList", postList);
			
				resp.sendRedirect("/");
				
			} else {
				
				session.setAttribute("message", "본인 게시물만 수정할 수 있습니다");
				
				resp.sendRedirect( req.getHeader("referer") );
			}
			
			
			
		} catch(Exception e) {
			System.out.println("[수정 중 예외 발생]");
			e.printStackTrace();
		}
	}

}
