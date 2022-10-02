package com.alexschaffer.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	
	@RequestMapping("")
	public String human() {
		return "Hello Human";
	}
	
	@RequestMapping("/search")
	public String fullName(
			@RequestParam(value="firstname", required = false) String firstName,
			@RequestParam(value="lastname", required = false) String lastName
			) {
		return "Hello " + firstName + " " + lastName;
	}
	
}
