package com.example.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



// 공용 컨트롤러입니다. 
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
    	System.out.println("Index Page 접속 테스트입니다~");
        return "index";
    }
}
