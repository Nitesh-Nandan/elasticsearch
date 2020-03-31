package com.nitesh.elk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {
	
	
	@Autowired
	private BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Book book = new Book("tale of two cities",
				"chales dickens", "penguin", 100.50f, "india");
		book.setId("1");
		
		var res = bookRepo.save(book);
		
		System.out.println("The Response from server is " + res);
		
		System.out.println("**********************It is runing****************");
		
	}

}