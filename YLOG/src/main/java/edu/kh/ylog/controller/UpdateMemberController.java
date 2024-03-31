package edu.kh.ylog.controller;

import java.io.IOException;

import edu.kh.ylog.member.model.dto.Member;
import edu.kh.ylog.member.model.service.MemberService;
import edu.kh.ylog.post.model.dto.Post;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateMember")
public class UpdateMemberController extends HttpServlet {
	
	private MemberService service = new MemberService(); 
	
	/**
	 * 로그인한 회원 정보 조회 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
		
			HttpSession session = req.getSession();
			Member member = (Member) session.getAttribute("loginMember");
			
			Member upMember = service.selectOne(member.getMemNo());
			
			req.setAttribute("upMember", upMember);
						
			req.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(req, resp);
			
			} catch (Exception e) {
				System.out.println("[회원 조회 중 예외 발생!]");
				e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	try {	
		HttpSession session = req.getSession(); 
		Member member = (Member)session.getAttribute("loginMember"); 
		String inputName = req.getParameter("name"); 
		String inputPw = req.getParameter("inputPw"); 
		String confirmPw = req.getParameter("confirmPw"); 
		
		if(!inputPw.equals(confirmPw)) {
			req.setAttribute("message", "비밀번호가 일치하지 않습니다");
			req.getRequestDispatcher("/WEB-INF/views/mypage.jsp").forward(req, resp); 
			return; 
		} 
		
		Member updateMember = new Member(); 
		
		updateMember.setMemNo(member.getMemNo());
		updateMember.setMemNickname(inputName);
		updateMember.setMemPw(inputPw);
		
		int result = service.updateMember(updateMember); 
		
		if(result > 0) {
			
			session.setAttribute("loginMember", updateMember);
			req.setAttribute("message", "정보 수정 완료!");			
			resp.sendRedirect(req.getContextPath() + "/mypage");
			
		} else {
			req.setAttribute("message", "정보 수정 실패!"); 
			resp.sendRedirect("/"); 
		}
		
		
		
	} catch (Exception e) {
		System.out.println("[회원 수정 중 예외 발생]");
		e.printStackTrace(); 
	}	
		
		
	}
	

	
	
	
	

}
