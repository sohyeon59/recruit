package com.example.recruit.jdbc.resume;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ResumeDetail {
	private int rno;
	private String cname;
	private String mname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date mbirth;
	private String memail;
	private String mphone;
	private String address;
	private String univ;
	private String major;
	private String career;
	private String experi;
	private String intro;
	

}
