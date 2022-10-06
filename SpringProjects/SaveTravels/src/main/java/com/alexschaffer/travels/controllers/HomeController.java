package com.alexschaffer.travels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alexschaffer.travels.models.Expense;
import com.alexschaffer.travels.services.ExpenseService;

@Controller
public class HomeController {
	@Autowired
	private ExpenseService expenseService;

	// SHOW ALL ON DASHBOARD
	@GetMapping("")
	public String dashboard(Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("expenseList", allExpenses);
		return "dashboard.jsp";
	}
	
	// -------- DETAILS -----------
	@GetMapping("/expenses/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		Expense foundExpense = expenseService.oneExpense(id);
		model.addAttribute("anExpense", foundExpense);
		return "details.jsp";
	}

	// ==============CREATE (DATA BINDING)==============================
	// Show the form
	@GetMapping("/")
	public String showCreateForm(Model model) {
		model.addAttribute("expenseList", expenseService.allExpenses());
		model.addAttribute("newExpense", new Expense());
		return "dashboard.jsp";
	}

	// Process the form
	@PostMapping("/expenses/new")
	public String newExpense(@Valid @ModelAttribute("newExpense") Expense expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("expenseList", expenseService.allExpenses());
			return "dashboard.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}

	// EDIT AND SAVE ENTRY (find one + create)===================================================
//	@PutMapping("/edit/{id}")
//	public Expense editExpenseProcess(@PathVariable("id") Long id,		
//			@RequestParam("expense") String expense,
//			@RequestParam("vendor") String vendor,
//			@RequestParam("amount") Integer amount,
//			@RequestParam("description") String description) {
//		Expense foundExpense = expenseService.oneExpense(id);
//		foundExpense.setExpense(expense);
//		foundExpense.setVendor(vendor);
//		foundExpense.setAmount(amount);
//		foundExpense.setDescription(description);
//		return expenseService.editExpense(foundExpense);
//	}
	
	//DELETE BY ID +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	@DeleteMapping("/expenses/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/";
	}
	
	
	//Another way of edit????????????????????????????????????????????????????????????????????????????????????
	//show form and get details from service, put into model
	@GetMapping("/expenses/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Expense foundExpense = expenseService.oneExpense(id);
		model.addAttribute( "anExpense", foundExpense);
		return "edit.jsp";
	}
	
	
	//process form
	@PutMapping("/expenses/edit/{id}")
	public String processEditForm(
			@Valid @ModelAttribute("anExpense")Expense expense, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			expenseService.editExpense(expense);
			return "redirect:/";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
