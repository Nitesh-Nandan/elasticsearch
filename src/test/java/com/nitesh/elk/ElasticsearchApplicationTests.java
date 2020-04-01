package com.nitesh.elk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;

@SpringBootTest
class ElasticsearchApplicationTests {
	
	
	@Autowired
	private BookRepository bookRepo;
	
	@Test
	void contextLoads() {
		
		System.out.println("Hello Test case passes successfully");
	}
	
	@Test
	public void runTest() {
		Book book = new Book("1",1,"tale of two cities",
				"chales dickens", "penguin", 100.50f, "india");
		
		var res = bookRepo.save(book);
		
		System.out.println("The Response from server is " + res);
		
	}
	


}
