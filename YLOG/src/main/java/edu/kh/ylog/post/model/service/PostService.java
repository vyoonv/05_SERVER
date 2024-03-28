package edu.kh.ylog.post.model.service;

import java.sql.Connection;
import java.util.List;
import static edu.kh.ylog.common.JDBCTemplate.*;
import edu.kh.ylog.post.model.dao.PostDAO;
import edu.kh.ylog.post.model.dto.Post;
import jakarta.servlet.http.HttpServletRequest;

public class PostService {
	
	private PostDAO postDao = new PostDAO(); 

	/** 포스트 전체조회 
	 * @return
	 * @throws Exception
	 */
	public List<Post> selectAll() throws Exception {
		
		Connection conn = getConnection(); 
		
		List<Post> postList = postDao.selectAll(conn);
		
		close(conn); 
		
		return postList;
	}
	
	/** 포스트 하나 조회 서비스 
	 * @param memNo
	 * @return
	 * @throws Exception
	 */
	public Post selectOne(int memNo) throws Exception{
		
		Connection conn = getConnection(); 
		
		Post post = postDao.selectOne(conn, memNo); 
		
		close(conn);
		
		return post;
		
	}

	/** 포스트 업로드 서비스 
	 * @param postTitle
	 * @param postContent
	 * @param memNo
	 * @return
	 */
	public int insert(String postTitle, String postContent, int memNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		int result = postDao.insert(conn, postTitle, postContent, memNo); 
		
		if(result>0) commit(conn); 
		else 		rollback(conn); 
		
		close(conn); 
		
		return result;
	}

	/** 포스트  조회하기 
	 * @param req
	 * @return
	 */
	public Post selectone(HttpServletRequest req) throws Exception {
		
		Connection conn = getConnection(); 
		
		Post post = postDao.selectone(conn, req);
		
		close(conn); 
		
		return post;
	}

	

}
