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


@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {

			String postNo = req.getParameter("postNo");
			
			PostService postService = new PostService();
			
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			
			int result = postService.delete(postNo, member.getMemNo());
						
			if(result > 0) {
				
				// todoList 갱신된것 구해서 속성값으로 재등록
				List<Post> postList = postService.selectAll(member.getMemNo());
				session.setAttribute("postList", postList);
				session.setAttribute("message", "삭제 완료!");
			
			} else {
				session.setAttribute("message", "본인 게시물만 삭제할 수 있습니다");
				
			}
			
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			System.out.println("[삭제 중 예외발생]");
			e.printStackTrace();
		}
	}
		
		
		
		
		
		
	}
	
	
	
	


