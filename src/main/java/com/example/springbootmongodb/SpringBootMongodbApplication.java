package com.example.springbootmongodb;

import com.example.springbootmongodb.model.Book;
import com.example.springbootmongodb.repo.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootMongodbApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBootMongodbApplication.class, args);
		BookRepo bookRepo = context.getBean(BookRepo.class);

		Book book = new Book();
		book.setId(2);
		book.setBookName("Java cookbook");
		book.setAuthorName("Barry baurd");
		bookRepo.save(book);
	}

}
