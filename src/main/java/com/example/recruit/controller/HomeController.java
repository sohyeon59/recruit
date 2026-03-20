package com.example.recruit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.recruit.jdbc.company.CompanyDto;
import com.example.recruit.jdbc.member.MemberDto;
import com.example.recruit.service.CompanyService;
import com.example.recruit.service.JobService;
import com.example.recruit.service.MemberService;
import com.example.recruit.util.PageHandler;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    HttpSession session;

    @Autowired
    MemberService memberService;

    @Autowired
    CompanyService companyService;

    @Autowired
    JobService jobService;

    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
        int pageSize = 10;
        int totalCount = jobService.totalCount();
        PageHandler ph = new PageHandler(totalCount, page, pageSize);

        model.addAttribute("jobList", jobService.list(page, pageSize));
        model.addAttribute("ph", ph);
        model.addAttribute("searchParam", ""); // pagination.jsp에서 사용
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
            session.setAttribute("alertMsg", result.getMname() + "님 로그인 되었습니다.");
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
        boolean result = memberService.regist(dto);
        if (result) {
            session.setAttribute("alertMsg", "회원가입 되었습니다. 로그인 페이지로 이동합니다.");
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
            session.setAttribute("loginName", result.getCname());
            session.setAttribute("userType", "company");
            session.setAttribute("alertMsg", result.getCname() + "님 로그인 되었습니다.");
            return "redirect:/";
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
            session.setAttribute("alertMsg", "회원가입 되었습니다. 로그인 페이지로 이동합니다.");
            return "redirect:/loginForm";
        } else {
            model.addAttribute("error", "이미 사용중인 아이디입니다.");
            return "regist";
        }
    }
}
