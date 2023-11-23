package com.TravelMaker.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.TravelMaker.model.TravelMaker_MemberDTO;

public class ValidUserInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String cpath = request.getContextPath();
		TravelMaker_MemberDTO user = (TravelMaker_MemberDTO)session.getAttribute("user");
		
		
		if(user!=null &&user.getTravelMaker_Member_IsExist().equals("N")) {
			System.out.println("없는 회원");
			response.sendRedirect(cpath+"/notExist");
			return false;
		}
		
		
		return true;
	}
}
