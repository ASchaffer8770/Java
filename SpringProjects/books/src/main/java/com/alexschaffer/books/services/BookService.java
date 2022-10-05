package com.alexschaffer.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexschaffer.books.models.Book;
import com.alexschaffer.books.repositories.BookRepository;

@Service
public class BookService {
	
	//option 1
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	//option 2 
//	@Autowired
//	private BookRepository bookRepo;
	
	// Save info to DB and inserts info to DB
	public Book createBook(Book newBook) {
		return bookRepo.save(newBook);
	}
	
	// Find all ( select * from books)
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	//Find one
	public Book oneBook(Long id) {
		Optional <Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//Edit
	public Book editBook(Book updatedBook) {
		return bookRepo.save(updatedBook);
	}
	
	//Delete
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
}
