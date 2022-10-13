package com.alexschaffer.auth.controllers;

import javax.servlet.http.HttpSession;
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

import com.alexschaffer.auth.models.Book;
import com.alexschaffer.auth.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	//SHOWS DASHBOARD============================================================
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			session.invalidate();
			return "redirect:/logout";
		}
		model.addAttribute("bookList", bookService.allBooks());
		return "dashboard.jsp";
	}
	
	//CREATE BOOK ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//SHOW CREATE BOOK FORM ON NEWBOOK JSP
	@GetMapping("/books/new")
	public String createBook(HttpSession session,
			@ModelAttribute("newBook")Book newBook) {
		if(session.getAttribute("userId")==null) {
			session.invalidate();
			return "redirect:/logout";
		}
		else {
			return "newBook.jsp";
		}
	}
	
	//PROCESS THE CREATE BOOK FROM
	@PostMapping("/books/process")
	public String processBook(HttpSession session, @Valid @ModelAttribute("newBook")Book book,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "newBook.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/dashboard";
		}
	}
	
	//DETAILS ----------------------------------------------------------------------
	@GetMapping("/books/{id}")
	public String bookDetails(
			@PathVariable("id")Long id, Model model) {
		Book foundBook = bookService.oneBook(id);
		model.addAttribute("book", foundBook);
		return "details.jsp";
	}
	
	//EDIT //////////////////////////////////////////////////////////////////////////
	//SHOW FORM
	@GetMapping("/books/edit/{id}")
	public String showEditForm(
			@PathVariable("id")Long id, Model model, HttpSession session) {
		Book foundBook = bookService.oneBook(id);
		model.addAttribute("book", foundBook);
		return "edit.jsp";
	}
	
	//PROCESS THE FORM
	@PutMapping("/books/edit/{id}")
	public String processEditBook(HttpSession session, @Valid @ModelAttribute("book")Book book,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			bookService.editBook(book);
			return "redirect:/dashboard";
		}
	}
	
	//DANGER ZONE!!!!! DELETE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(
			@PathVariable("id")Long id) {
		bookService.deleteBook(id);
		return "redirect:/dashboard";
	}
	
}




