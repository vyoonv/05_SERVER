package edu.kh.ylog.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import static edu.kh.ylog.common.JDBCTemplate.*;

import edu.kh.ylog.member.model.dao.MemberDAO;
import edu.kh.ylog.member.model.dto.Member;

public class MemberDAO {
	
	private Statement stmt; 
	private PreparedStatement pstmt; 
	private ResultSet rs;
	private Properties prop; 
	
	public MemberDAO() {
		
		try {
			
			prop = new Properties(); 
			
			String filePath 
			 	= MemberDAO.class.getResource("/edu/kh/ylog/sql/member-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/** 로그인 수행 dao
	 * @param conn
	 * @param inputId
	 * @param inputPw
	 * @return
	 */
	public Member login(Connection conn, String inputId, String inputPw) throws Exception {
	
		Member loginMember =null; 
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputPw);
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				loginMember = new Member(); 
				
				loginMember.setMemNo(rs.getInt("MEM_NO"));
				loginMember.setMemId(rs.getString("MEM_ID"));
				loginMember.setMemNickname(rs.getString("MEM_NN"));
				loginMember.setEnrollDate(rs.getString("ENROLL_DATE"));
				
			}
			
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return loginMember;
	}

	/** 회원가입 dao
	 * @param conn
	 * @param member
	 * @return result 
	 */
	public int signup(Connection conn, Member member) throws Exception {
	
		int result = 0; 
		
		try {
			
			String sql = prop.getProperty("signup");
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, member.getMemId());
			pstmt.setString(2, member.getMemPw());
			pstmt.setString(3, member.getMemNickname());
			
			result = pstmt.executeUpdate(); 
			
			
			
		} finally {
			
			close(pstmt); 
			
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	

}
