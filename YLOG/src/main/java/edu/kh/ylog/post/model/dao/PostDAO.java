package edu.kh.ylog.post.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.ylog.member.model.dao.MemberDAO;
import edu.kh.ylog.post.model.dto.Post;
import jakarta.servlet.http.HttpServletRequest;

import static edu.kh.ylog.common.JDBCTemplate.*;




public class PostDAO {
	
	private Statement stmt; 
	private PreparedStatement pstmt; 
	private ResultSet rs;
	private Properties prop; 
	
	
	public PostDAO() {
		
		try {
			
			prop = new Properties(); 
			
			String filePath 
			 	= MemberDAO.class.getResource("/edu/kh/ylog/sql/post-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 포스트 하나조회 
	 * @param conn
	 * @param memNo
	 * @param postNo
	 * @return
	 * @throws Exception
	 */
	public Post selectOne(Connection conn, int memNo, String postNo) throws Exception {
		
		Post post = new Post(); 
		
		try {
			
			String sql = prop.getProperty("selectOne"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, memNo);
			pstmt.setString(2, postNo);
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
		
				post.setPostNo(rs.getInt("P_NO"));
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				
			}
					
			
		} finally {
			close(rs); 
			close(pstmt);
		}
			
		return post;
	}


	/** 포스트 전체 조회 
	 * @param conn
	 * @param memNo 
	 * @return
	 */
	public List<Post> selectAll(Connection conn, int memNo) throws Exception{
		
		List<Post> postList = new ArrayList<Post>();
		
		try {
			
			String sql = prop.getProperty("selectAll"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, memNo);
			
			rs = pstmt.executeQuery(); 
						
			while(rs.next()) {
				
				Post post = new Post(); 
				
				post.setPostNo(rs.getInt("P_NO"));
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				post.setPostCreateDate(rs.getString("CREATE_DT"));
				
				postList.add(post); 
				
			}
			
			
			
		} finally {
			
			close(rs); 
			close(pstmt); 
			
		}
		
		
		return postList;
	}


	/** 포스트 업로드 서비스 
	 * @param conn
	 * @param postTitle
	 * @param postContent
	 * @param memNo
	 * @return
	 */
	public int insert(Connection conn, String postTitle, String postContent, int memNo) throws Exception {
		
		int result = 0; 
		
		try {
			
			String sql = prop.getProperty("insert");
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, postTitle);
			pstmt.setString(2, postContent); 
			pstmt.setInt(3, memNo); 
			
			result = pstmt.executeUpdate(); 
			
			
			
		} finally {
			close(pstmt); 
		}
		
		
		
		
		return result;
	}


/*	public Post selectone(Connection conn, String postNo) throws Exception {
		
		Post post = null; 
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, postNo);
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				
				post = new Post(); 
				
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				post.setPostCreateDate(rs.getString("CREATE_DT"));
				
			}
					
			
		} finally {
			close(rs); 
			close(pstmt);
		}
		

		
		return post;
		
		
		
	} */

/*
	public Post selectone(Connection conn, String postNo, int memNo) throws Exception {
		
		Post post = null; 
		
		try {
			
			String sql = prop.getProperty("selectone"); 
			
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setInt(1, memNo);
			pstmt.setString(2, postNo);
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				
				post = new Post(); 
				
				post.setPostNo(rs.getInt("P_NO"));
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				post.setPostCreateDate(rs.getString("CREATE_DT"));
				
			}
			
			
		} finally {
			
			close(rs); 
			close(pstmt); 
			
		}
		
		
		return post;
	}    */


	/** 수정 
	 * @param conn
	 * @param postTitle
	 * @param postContent
	 * @param memNo
	 * @param postNo
	 * @return
	 */
	public int update(Connection conn, String postTitle, String postContent, int memNo, String postNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("update");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, postTitle);
			pstmt.setString(2, postContent);
			pstmt.setString(3, postNo);
			pstmt.setInt(4, memNo);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
		
	}


	/** 삭제 
	 * @param conn
	 * @param postNo
	 * @param memNo 
	 * @return
	 */
	public int delete(Connection conn, String postNo, int memNo) throws Exception {
		
		int result = 0; 
		
		try {
			
			String sql = prop.getProperty("delete"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, postNo);
			pstmt.setInt(2, memNo);
			
			result = pstmt.executeUpdate(); 
			
		} finally {
			
			close(pstmt); 
			
		}		
		return result;
	}


	/** 전체 포스트 
	 * @param conn
	 * @return
	 */
	public List<Post> selectMain(Connection conn) throws Exception{
		
		List<Post> postList = new ArrayList<Post>();
		
		try {
			
			String sql = prop.getProperty("selectMain"); 
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql); 
						
			while(rs.next()) {
				
				Post post = new Post(); 
				
				post.setPostNo(rs.getInt("P_NO"));
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				post.setPostCreateDate(rs.getString("CREATE_DT"));
				post.setMemNo(rs.getInt("MEM_NO"));
				
				postList.add(post); 
				
			}
			
			
			
		} finally {
			
			close(rs); 
			close(stmt); 
			
		}
		
		
		return postList;

	}




	
	
	
	

}
