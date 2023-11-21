package com.itbank.test1;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		
		String java_home = System.getenv("JAVA_HOME");
		String catalina_home = System.getenv("CATALINA_HOME");
		String spring_version = SpringVersion.getVersion();
		
		request.setAttribute("java_home", java_home);
		request.setAttribute("catalina_home", catalina_home);
		request.setAttribute("spring_version", spring_version);
		
		return "home";
	}
	
}
