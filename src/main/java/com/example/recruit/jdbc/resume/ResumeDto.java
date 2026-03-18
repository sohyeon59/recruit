package com.example.recruit.jdbc.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {
	
	int rno;
	int jno;
	String mid;
	String address;
	String univ;
	String major;
	String career;
	String experi;
	String intro;
	String cname;
}