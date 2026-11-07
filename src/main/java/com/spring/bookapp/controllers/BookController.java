package com.spring.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.bookapp.entities.Book;
import com.spring.bookapp.services.BookService;

@RestController
@RequestMapping("/book/v1")
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	/*For adding a new book to database
	 We will send json as a request hence RequestBody is passed as parameter 
	 */
	@PostMapping("/addBook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.addBook(book);
		return ResponseEntity.ok(savedBook);
		
	}
	
	/*For fetching the books by their name
	 We are passing name in url hence Path Variable is used in parameter
	 */
	@GetMapping("/getBook/{name}")
	public ResponseEntity<Book> getBook(@PathVariable("name") String name) {
		Book getBook = bookService.getBook(name);
		return ResponseEntity.ok(getBook);
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		Book updateBook = bookService.updateBook(book);
		return ResponseEntity.ok(updateBook);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
}
