package edu.kh.ylog.member.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Member {
	
	
	private int memNo; 
	private String memId; 
	private String memPw; 
	private String memNickname; 
	private String enrollDate; 
	private String memDeleteFlag; 


}
