package com.alexschaffer.auth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexschaffer.auth.models.Book;
import com.alexschaffer.auth.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	//CREATE
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	//FIND ONE
	public Book oneBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	//FIND ALL
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	//EDIT PROCESS
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}
	
	//DELETE
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
	
	
}
