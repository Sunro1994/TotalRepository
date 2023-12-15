package com.erp.ErpMaster.login;

import com.erp.ErpMaster.member.entity.Member;
import com.erp.ErpMaster.security.auth.MemberPrincipalDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }



    @GetMapping("/member/login/loginForm")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "t", required = false) String t,
                        HttpServletRequest request,
                        @AuthenticationPrincipal MemberPrincipalDetails memberPrincipalDetails) {
        HttpSession session = request.getSession();
        String msg = (String) session.getAttribute("loginErrorMessage");
        session.setAttribute("loginErrorMessage", msg != null ? msg : "");

        if(isAuthenticated()) {
            if(memberPrincipalDetails == null)
                return "redirect:/member/login/logout";
            return "redirect:/member/main";
        }

        return "login/login";
    }

    @GetMapping("/member/main")
    public String main() {
        return "main/main";
    }

    @GetMapping("/member/text")
    public String text(@AuthenticationPrincipal MemberPrincipalDetails memberPrincipalDetails
            , Model model) {

        Member member = memberPrincipalDetails.getMember();

        model.addAttribute("member", member);
        return "text/text";
    }
};
