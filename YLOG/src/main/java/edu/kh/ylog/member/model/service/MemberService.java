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

}
