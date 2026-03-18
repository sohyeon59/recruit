package com.example.recruit.jdbc.resume;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ResumeDetail {
	
	String cname;
	String mname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date mbirth;
	String memail;
	String mphone;
	String address;
	String univ;
	String major;
	String career;
	String experi;
	String intro;
	

}
