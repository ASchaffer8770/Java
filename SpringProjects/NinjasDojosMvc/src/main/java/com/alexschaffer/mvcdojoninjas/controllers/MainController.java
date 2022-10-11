package com.alexschaffer.mvcdojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexschaffer.mvcdojoninjas.models.Dojo;
import com.alexschaffer.mvcdojoninjas.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	//creates new ninja
	@GetMapping("/ninja/new")
	public String ninjaDashboard() {
		return "NewNinja.jsp";
	}
	
	//creates new dojo
	//show the form
	@GetMapping("/dojo/new")
	public String newDojo(Model model) {
		model.addAttribute("newDojo", new Dojo());
		return "NewDojo.jsp";
	}
	//submits the dojo form
	@PostMapping("/dojo/process")
	public String processDojoForm(
			@Valid @ModelAttribute("newDojo") Dojo dojo,
			BindingResult result) {
		if (result.hasErrors()) {
			return "NewDojo.jsp";
		} else {
			mainService.createDojo(dojo);
			return "NewNinja.jsp";
		}
	}
}
