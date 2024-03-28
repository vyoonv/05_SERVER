package edu.kh.ylog.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Post {
	
	private int postNo; 
	private String postTitle;
	private String postContent; 
	private String postCreateDate; 
	private String postDeleteFlag; 
	
	
}
