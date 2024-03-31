package edu.kh.ylog.member.model.service;

import edu.kh.ylog.member.model.dao.MemberDAO;
import edu.kh.ylog.member.model.dto.Member;

import static edu.kh.ylog.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	
	private MemberDAO dao = new MemberDAO();
	

	/** 로그인 서비스 
	 * @param inputId
	 * @param inputPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String inputId, String inputPw) throws Exception {
		
		Connection conn = getConnection(); 
		
		Member loginMember = dao.login(conn, inputId, inputPw); 
		
		close(conn); 
		
		return loginMember;
	}


	/** 회원 가입 서비스 
	 * @param member
	 * @return result
	 */
	public int signup(Member member) throws Exception {
		
		
		Connection conn = getConnection(); 
	
		int result = dao.signup(conn, member);
		
		if(result >0) commit(conn); 
		else 		rollback(conn); 
		
		close(conn);
		
		return result;
	}


	/** 아이디 중복 검사 서비스 
	 * @param inputId
	 * @return
	 */
	public int duplicationCheck(String inputId) throws Exception {
		
		Connection conn = getConnection(); 
		
		int idResult = dao.duplicationCheck(conn, inputId); 
		
		close(conn); 

		return idResult;
	}


	/** 로그인한 회원 정보 조회 
	 * @param memNo
	 * @return
	 */
	public Member selectOne(int memNo) throws Exception {
		
		Connection conn = getConnection(); 
		
		Member upMember = dao.selectOne(conn, memNo);
		
		close(conn); 
		
		
		return upMember;
	}


	/** 내정보 수정 (닉네임, 비밀번호) 
	 * @param updateMember
	 * @return 
	 */
	public int updateMember(Member updateMember) throws Exception {
		
		Connection conn = getConnection(); 
		
		int result = dao.updateMember(conn, updateMember); 
		
		if(result>0) commit(conn); 
		else 		rollback(conn); 
		
		close(conn); 
		
		return result; 
	
		
	}


	

}
