package edu.kh.ylog.controller;

import java.io.IOException;

import edu.kh.ylog.member.model.dto.Member;
import edu.kh.ylog.member.model.service.MemberService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/signup")
public class SignupController extends HttpServlet{
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(req, resp);
	}
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String inputId = req.getParameter("inputId"); 
			String inputPw = req.getParameter("inputPw");
			String inputName = req.getParameter("inputName");
			
			Member member = new Member(); 
			
			member.setMemId(inputId);
			member.setMemPw(inputPw);
			member.setMemNickname(inputName);
			
			MemberService service = new MemberService(); 
			
			int result = service.signup(member);
			
			HttpSession session = req.getSession(); 
			
			if(result > 0) {
				
				session.setAttribute("message", "가입 완료!");
				resp.sendRedirect("/");
				
			} else {
				session.setAttribute("message", "회원가입 실패...");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("[회원가입 중 예외 발생!]");
			e.printStackTrace();
		}
		
	} 

}
