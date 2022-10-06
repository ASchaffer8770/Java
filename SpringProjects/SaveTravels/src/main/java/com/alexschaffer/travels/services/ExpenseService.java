package com.alexschaffer.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexschaffer.travels.models.Expense;
import com.alexschaffer.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	//option 1
	private final ExpenseRepository expenseRepo;
	
	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	// save info to database
	public Expense createExpense(Expense newExpense) {
		return expenseRepo.save(newExpense);
	}
	
	//find all
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
	//Find One
	public Expense oneExpense(Long id) {
		Optional <Expense> optionalExpense = expenseRepo.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		} else {
			return null;
		}
	}
	
	//Edit
	public Expense editExpense( Expense updatedExpense) {
		return expenseRepo.save(updatedExpense);
	}
	
	//Delete
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}
	
	
}
