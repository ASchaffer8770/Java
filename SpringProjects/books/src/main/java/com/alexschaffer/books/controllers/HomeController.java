package com.alexschaffer.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alexschaffer.books.models.Book;
import com.alexschaffer.books.services.BookService;

@Controller
public class HomeController {
	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books")
	public String dashboard(Model model) {
		List <Book> allBooks = bookService.allBooks();
		model.addAttribute("bookList", allBooks);
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model) {
		Book oneBook = bookService.oneBook(id);
		model.addAttribute("book", oneBook);
		return "details.jsp";
	}
	
}
