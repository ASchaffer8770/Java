package com.alexschaffer.mvcdojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexschaffer.mvcdojoninjas.models.Dojo;
import com.alexschaffer.mvcdojoninjas.models.Ninja;
import com.alexschaffer.mvcdojoninjas.services.MainService;

@Controller
public class MainController {

	@Autowired
	private MainService mainService;
	
	//creates new ninja
	//1 show the form
	@GetMapping("/ninja/new")
	public String showNinjaForm(Model model) {
		model.addAttribute("addNinja", new Ninja());
		model.addAttribute("dojoList", mainService.allDojos());
		return "NewNinja.jsp";
	}
	//2 process the form
	@PostMapping("/ninja/process")
	public String processNinja(
 			@Valid @ModelAttribute("addNinja")Ninja ninja,
 			BindingResult result) {
		if (result.hasErrors()) {
			return "NewNinja.jsp";
		} else {
			mainService.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	
	//============================================================================================
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
			return "redirect:/";
		}
	}
	
	
	//++++++++++++++++++++++++++++++++DASHBOARD CONTROLS++++++++++++++++++++++++++++++++++++++++++
	@GetMapping("/")
	public String dashboard(Model model) {
		model.addAttribute("dojoList", mainService.allDojos());
		return "ninjasDojo.jsp";
	}
	
	
	//))))))))))))))))))))))))))))))))))))))))))))))))))))  GET ONE DOJO DETAILS  ))))))))))))))))))))))))))))))
	@GetMapping("/dojo/{id}") 
	public String details(
			@PathVariable("id")Long id, Model model) {
		Dojo foundDojo = mainService.oneDojo(id);
		model.addAttribute("dojo", foundDojo);
		return "dojoDetails.jsp";
	}
	
	
	
	
	
}





