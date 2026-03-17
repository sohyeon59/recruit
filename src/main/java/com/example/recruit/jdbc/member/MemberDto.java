package com.example.recruit.jdbc.member;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	
	String mid;
	String mpw;
	String mname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date mbirth;
	String memail;
	String mphone;
	

}