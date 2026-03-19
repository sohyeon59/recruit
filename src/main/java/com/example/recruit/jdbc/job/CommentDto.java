package com.example.recruit.jdbc.job;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

	private int cno;
	private int jno;
	private String mid;
	private Date created_at;
	
	
}
