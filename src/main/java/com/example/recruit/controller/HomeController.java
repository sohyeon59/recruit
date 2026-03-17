package com.example.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.recruit.jdbc.resume.ResumeDto;



// 공용 컨트롤러입니다. 
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
    	System.out.println("Index Page 접속 테스트입니다~");
        return "index";
    }
    
    @GetMapping("/resumePage")
    public String resumePage() { 	
    	return "resume";
    }
    
    @PostMapping("/regResume")
    public String regResume(ResumeDto resume, Model model) {
    	
    	return "redirect:myPage";
    }
    
    
    
}
