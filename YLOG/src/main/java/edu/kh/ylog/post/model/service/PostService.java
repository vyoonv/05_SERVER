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
	 * @param i 
	 * @return
	 * @throws Exception
	 */
	public List<Post> selectAll(int memNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		List<Post> postList = postDao.selectAll(conn, memNo);
		
		close(conn); 
		
		return postList;
	}
	
	/** 포스트 하나 조회 서비스 
	 * @param string 
	 * @param memNo
	 * @return
	 * @throws Exception
	 */
	public Post selectOne(String postNo, int memNo) throws Exception{
		
		Connection conn = getConnection(); 
		
		Post post = postDao.selectOne(conn, memNo, postNo); 
		
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


/*
	public Post selectone(String postNo, int memNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		Post post = postDao.selectone(conn, postNo, memNo); 
		
		close(conn); 
		
		return post;
	}  */

	/** 수정
	 * @param postTitle
	 * @param postContent
	 * @param memNo
	 * @param postNo
	 * @return
	 */
	public int update(String postTitle, String postContent, int memNo, String postNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = postDao.update(conn, postTitle, postContent, memNo, postNo);
		
		if(result > 0) commit(conn);
		else 		rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 삭제 
	 * @param postNo
	 * @param memNo 
	 * @return
	 */
	public int delete(String postNo, int memNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		int result = postDao.delete(conn, postNo, memNo);
		
		if (result>0) commit(conn); 
		else 		rollback(conn); 
		
		return result;
	}

	/** 전체 포스트 조회 메인 화면 
	 * @return
	 */
	public List<Post> selectMain() throws Exception {
		
		Connection conn = getConnection(); 
		
		List<Post> postList = postDao.selectMain(conn);
		
		close(conn); 
		
		return postList;

	}


	

}
