package com.example.recruit.jdbc.member;

import java.util.Date;

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
	Date mbirth;
	String memail;
	String mphone;
	

}