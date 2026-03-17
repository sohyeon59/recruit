package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.MemberService;

import jakarta.servlet.http.HttpSession;

// 공용 컨트롤러입니다.
@Controller
public class HomeController {

	
	//회원가입 페이지 가기

    @Autowired
    HttpSession session;

    @Autowired
    MemberService memberService;

    @Autowired
    CompanyService companyService;

    @GetMapping("/")
    public String home() {
        System.out.println("Index Page 접속 테스트입니다~");
        return "index";
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    // 로그인 페이지
    @GetMapping("/loginForm")
    public String loginPage() {
        return "login";
    }


    // 개인회원 로그인
    @PostMapping("/login/member")
    public String loginM(MemberDto dto, Model model) {
        MemberDto result = memberService.login(dto);
        if (result != null) {
            session.setAttribute("loginMember", result);
            session.setAttribute("loginName", result.getMname());
            session.setAttribute("userType", "member");
            return "redirect:/";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    // 회원가입 페이지
    @GetMapping("/registForm")
    public String registPage() {
        return "regist";
    }

    // 개인회원 가입
    @PostMapping("/register/member")
    public String registM(MemberDto dto, Model model) {
        System.out.println("회원가입 서블릿");
        boolean result = memberService.regist(dto);
        System.out.println(dto.toString());
        if (result) {
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }

    // 기업회원 로그인
    @PostMapping("/login/company")
    public String loginC(CompanyDto dto, Model model) {
        CompanyDto result = companyService.login(dto);
        if (result != null) {
            session.setAttribute("loginCompany", result);
            session.setAttribute("userType", "company");
            return "redirect:/company/main";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "login";
        }
    }

    // 기업회원 가입
    @PostMapping("/register/company")
    public String registC(CompanyDto dto, Model model) {
        boolean result = companyService.regist(dto);
        if (result) {
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }
}