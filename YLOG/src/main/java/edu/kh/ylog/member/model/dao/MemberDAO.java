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
	
		Member loginMember = null; 
		
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

	/** 아이디 중복 검사 
	 * @param conn
	 * @param inputId
	 * @return 
	 */
	public int duplicationCheck(Connection conn, String inputId) throws Exception {
		
		int idResult = 0; 
		
		try {
			
			String sql = prop.getProperty("duplicationCheck"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, inputId);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				idResult = rs.getInt(1); 
			}
			
			
		} finally {
			
			close(rs); 
			close(pstmt); 
		}
		
		
		
		return idResult;
	}

	/** 회원 정보 조회 
	 * @param conn
	 * @param memNo
	 * @return
	 * @throws Exception
	 */
	public Member selectOne(Connection conn, int memNo) throws Exception {
		
		Member upMember = null; 
		
		try {
			
			String sql = prop.getProperty("selectOne"); 
			
			pstmt = conn.prepareStatement(sql); 
			
			pstmt.setInt(1, memNo);
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				upMember = new Member(); 
				
				upMember.setMemNo(rs.getInt("MEM_NO"));
				upMember.setMemId(rs.getString("MEM_ID"));
				upMember.setMemNickname(rs.getString("MEM_NN"));
				upMember.setEnrollDate(rs.getString("ENROLL_DATE"));
				
			}
		
		} finally {
			
			close(rs); 
			close(pstmt); 
			
		}
		
		return upMember;
	}

	public int updateMember(Connection conn, Member updateMember) throws Exception {
		
		int result = 0;  
		
		try {
			
			String sql = prop.getProperty("updateMember"); 
			
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, updateMember.getMemNickname());
			pstmt.setString(2, updateMember.getMemPw());
			pstmt.setInt(3, updateMember.getMemNo());
			
			result = pstmt.executeUpdate(); 
		
		} finally {
			
			close(pstmt); 
			
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	

}
