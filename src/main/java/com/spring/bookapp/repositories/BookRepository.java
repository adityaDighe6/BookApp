package com.spring.bookapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.bookapp.entities.Book;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	public Book findByTitle(String title);
}
