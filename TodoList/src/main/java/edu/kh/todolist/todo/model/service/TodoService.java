package edu.kh.todolist.todo.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.todolist.common.JDBCTemplate.*;
import edu.kh.todolist.todo.model.dao.TodoDAO;
import edu.kh.todolist.todo.model.dto.Todo;

public class TodoService {
	
	private TodoDAO dao = new TodoDAO(); 

	/** 로그인한 회원의 todoList 전체 조회하기 서비스 
	 * @param memberNo
	 * @return todoList
	 */
	public List<Todo> selectAll(int memberNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		List<Todo> todoList = dao.selectAll(conn, memberNo); 
		
		close(conn);
		
		return todoList;
	}

	/** Todo 등록하기 서비스 
	 * @param title
	 * @param memo
	 * @param memberNo
	 * @return result 
	 */
	public int insert(String title, String memo, int memberNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		int result = dao.insert(conn, title, memo, memberNo); 
		
		if(result>0) commit(conn); 
		else		rollback(conn); 
		
		close(conn); 
		
		return result;
	}

	/** todo 삭제 서비스 
	 * @param todoNo
	 * @return result 
	 */
	public int delete(String todoNo) throws Exception{
		
		Connection conn = getConnection(); 
		
		int result = dao.delete(conn, todoNo); 
		
		if(result>0) commit(conn); 
		else 		rollback(conn); 
		
		close(conn); 
		
		return result;
	}

	/** todo 수정 서비스 
	 * @param todoNo
	 * @param memo 
	 * @param title 
	 * @return
	 */
	public int update(String todoNo, String title, String memo) throws Exception {
		
		Connection conn = getConnection(); 
		
		int result = dao.update(conn, todoNo, title, memo); 
		
		if(result>0) commit(conn); 
		else 		rollback(conn); 
		
		close(conn); 
		
		return result;
	}

}
