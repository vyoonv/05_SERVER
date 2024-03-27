package edu.kh.todolist.todo.controller;

import java.io.IOException;
import java.util.List;

import edu.kh.todolist.member.model.dto.Member;
import edu.kh.todolist.todo.model.dto.Todo;
import edu.kh.todolist.todo.model.service.TodoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			String todoNo = req.getParameter("todoNo");		
			String title = req.getParameter("title"); 
			String memo = req.getParameter("memo"); 
			
			TodoService service = new TodoService(); 
			
			
			
			int result = service.update(todoNo, title, memo); 
			
			HttpSession session = req.getSession(); 
			Member member = (Member) session.getAttribute("loginMember"); 
			
			if(result>0) {
				
				session.setAttribute("message", "수정되었습니다");
				
				//todoList 갱신된 것 속성값으로 재등록 
				List<Todo> todoList = service.selectAll(member.getMemberNo()); 
				session.setAttribute("todoList", todoList);  // "todoList" 키에 덮어쓰기 
				
				
				resp.sendRedirect("/");
				
			} else {
				session.setAttribute("message", "수정 실패!");
				
				
			}
			
			resp.sendRedirect(req.getHeader("referer")); 
			
		} catch(Exception e) {
			
			System.out.println("[수정 중 예외 발생]");
			e.printStackTrace();
			
		}
		
		
		
		
		
	}
	
	
	
}
