package com.example.recruit.jdbc.resume;

import java.util.Date;

import lombok.Data;

@Data
public class ResumeList {
	int rno;
	String cname;
	String title;
	Date deadline;
}
