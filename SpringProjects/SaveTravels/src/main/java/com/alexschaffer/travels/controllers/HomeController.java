package com.alexschaffer.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexschaffer.travels.models.Expense;
import com.alexschaffer.travels.services.ExpenseService;

@Controller
public class HomeController {
	@Autowired
	private ExpenseService expenseService;
	
	
	//SHOW ALL ON DASHBOARD
	@GetMapping("")
	public String dashboard(Model model) {
		List <Expense> allExpenses =expenseService.allExpenses();
		model.addAttribute("expenseList", allExpenses);
		return "dashboard.jsp";
	}
	
	//==============CREATE (DATA BINDING)==============================
	//Show the form
	@GetMapping("/")
	public String showCreateForm(Model model) {
		model.addAttribute("expenseList", expenseService.allExpenses());
		model.addAttribute("newExpense", new Expense());
		return "dashboard.jsp";
	}
	
	//Process the form
	@PostMapping("/expenses/new")
	public String newExpense(
			@Valid @ModelAttribute("newExpense") Expense expense,
			BindingResult result
			) {
		if(result.hasErrors()) {
			return "dashboard.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
}
