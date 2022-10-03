package com.alexschaffer.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	//shows the form
	@GetMapping("/")
	public String home() {
		return "form.jsp";
	}
	
	
	//submits the form -- get the info from the form @requestParam -- save result in session
	@PostMapping("/submitted")
	public String processForm(
			@RequestParam("number")Integer number,
			@RequestParam("city") String city,
			@RequestParam("person") String person,
			@RequestParam("profession") String profession,
			@RequestParam("living") String living,
			@RequestParam("comments") String comments,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("profession", profession);
		session.setAttribute("living", living);
		session.setAttribute("comments", comments);
		return "redirect:/submitted";
	}
	
	//review the results of the form
	@GetMapping("/submitted")
	public String submittedReview() {
		return "submitted.jsp";
	}
}
