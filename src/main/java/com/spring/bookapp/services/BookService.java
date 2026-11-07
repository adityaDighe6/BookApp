package com.spring.bookapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.bookapp.entities.Book;
import com.spring.bookapp.repositories.BookRepository;
@Service
public class BookService {

	@Autowired
	public BookRepository bookRepo;
	
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		Book savedBook = bookRepo.save(book);
		return savedBook;
	}

	public Book getBook(String name) {
		// TODO Auto-generated method stub
		return bookRepo.findByTitle(name);
		
	}

	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookRepo.save(book);
	}

	public void deleteBook(Integer id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
	}

}
