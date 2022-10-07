package com.alexschaffer.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexschaffer.dojosandninjas.models.Dojo;
import com.alexschaffer.dojosandninjas.services.MainService;

@Controller
public class HomeController {
	@Autowired
	private MainService mainService; 
	
	//Create Dojo
	//Show
	@GetMapping("/")
	public String createDojoForm(Model model) {
		model.addAttribute("newDojo", new Dojo());
		return "newDojo.jsp";
	}
	//Process Dojo
	@PostMapping("/dojo/process")
	public String processDojoForm(
			@Valid @ModelAttribute("newDojo")Dojo dojo,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			mainService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	
	//Create Ninja
	@GetMapping("/ninjas/new")
	public String createNinjaForm() {
		return "newNinja.jsp";
	}
	
	//Process Ninja
	
}





