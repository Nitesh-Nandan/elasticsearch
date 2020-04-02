package com.nitesh.elk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;

@SpringBootTest
class ElasticsearchApplicationTests {
	
	
	@Test
	void contextLoads() {
		
		System.out.println("Hello Test case passes successfully");
	}
	
}
