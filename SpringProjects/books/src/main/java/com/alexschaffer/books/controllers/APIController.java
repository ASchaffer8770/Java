package com.alexschaffer.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexschaffer.books.models.Book;
import com.alexschaffer.books.services.BookService;

@RestController
@RequestMapping("/api")
public class APIController {

		@Autowired
		private BookService bookService;
		
		//find all books
		@GetMapping("/books")
		public List<Book> showBooks(){
			return bookService.allBooks();
		}
		
		
		//create one book
		@PostMapping("/books")
		public Book createBook(
				@RequestParam("title") String title,
				@RequestParam("description") String description,
				@RequestParam("language") String language,
				@RequestParam("numberOfPages") Integer numberOfPages
				) {
			Book newBook = new Book(title, description, language, numberOfPages);
			
			return bookService.createBook(newBook);
		}
		
		//find one book by ID
		@GetMapping("/books/{id}")
		public Book getOneBook(@PathVariable("id")Long id) {
			return bookService.oneBook(id);
		}
		
		
		//edit book (findOne + create)
		@PutMapping("/books/{id}")
		public Book editBook(@PathVariable("id") Long id,
				@RequestParam("title") String title,
				@RequestParam("description") String description,
				@RequestParam("language") String language,
				@RequestParam("numberOfPages") Integer numberOfPages
				) {
			Book foundBook = bookService.oneBook(id);
			foundBook.setTitle(title);
			foundBook.setDescription(description);
			foundBook.setLanguage(language);
			foundBook.setNumberOfPages(numberOfPages);
			return bookService.editBook(foundBook);
		}
		
		//Delete
		@DeleteMapping("/books/{id}")
		public void deleteBook(@PathVariable("id")Long id) {
			bookService.deleteBook(id);
		}
		
}







