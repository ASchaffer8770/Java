package com.alexschaffer.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.alexschaffer.dojosandninjas.services.MainService;

@Controller
public class HomeController {
	@Autowired
	private MainService mainService; 
	
	//Create Dojo
	//Show
	@GetMapping("/")
	public String createDojoForm() {
		return "newDojo.jsp";
	}
	
	//Process Dojo
	
	
	//Create Ninja
	@GetMapping("/ninjas/new")
	public String createNinjaForm() {
		return "newNinja.jsp";
	}
	
	//Process Ninja
	
}





