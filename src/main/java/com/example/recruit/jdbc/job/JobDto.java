package com.example.recruit.jdbc.job;

import java.sql.Date;

import lombok.Data;

@Data
public class JobDto {
	private int jno;
	private String cid;
	private String cname;
	private String title;
	private String content;
	private Date deadline;
}