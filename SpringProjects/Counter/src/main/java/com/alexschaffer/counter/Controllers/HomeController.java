package com.alexschaffer.counter.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String sessionHome(HttpSession session) {
		
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		} else {
			//get count from session
			Integer tempCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", tempCount+1);
		}
		
		return ("/add.jsp");
	}
	
	@GetMapping("/counter")
	public String getCount() {
		return ("/counter.jsp");
	}
	
}
