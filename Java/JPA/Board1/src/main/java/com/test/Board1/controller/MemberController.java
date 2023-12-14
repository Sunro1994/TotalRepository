package com.test.Board1.controller;

import com.test.Board1.entity.Member;
import com.test.Board1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;


    @GetMapping("/member/join")
    public String join() {
        return "/member/join";
    }

    @PostMapping("/member/join")
    public ModelAndView join(Member member) {
        ModelAndView mav = new ModelAndView();
        memberService.join(member);
        mav.setViewName("/");


        return mav;
    }
}
