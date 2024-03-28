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


	public Post selectOne(Connection conn, int memNo) throws Exception {
		
		Post post = null; 
		
		try {
			
			String sql = prop.getProperty("selectOne"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, memNo);
			
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
	}


	/** 포스트 전체 조회 
	 * @param conn
	 * @return
	 */
	public List<Post> selectAll(Connection conn) throws Exception{
		
		List<Post> postList = new ArrayList<Post>();
		
		try {
			
			String sql = prop.getProperty("selectAll"); 
			
			stmt = conn.createStatement(); 
			rs = stmt.executeQuery(sql);
			
			
			
			while(rs.next()) {
				
				Post post = new Post(); 
				
				post.setPostTitle(rs.getString("P_TITLE"));
				post.setPostContent(rs.getString("P_CONTENT"));
				post.setPostCreateDate(rs.getString("CREATE_DT"));
				
				postList.add(post); 
				
			}
			
			
			
		} finally {
			
			close(rs); 
			close(stmt); 
			
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


	public Post selectone(Connection conn, HttpServletRequest req) throws Exception {
		
		Post post = null; 
		
		try {
			
			String sql = prop.getProperty("selectOne");
			
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, post.getPostNo());
			
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
		
		
		
	}




	
	
	
	

}
