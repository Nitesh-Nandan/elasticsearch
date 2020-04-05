package com.nitesh.elk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nitesh.elk.service.BookRepositoryDAO;

@SpringBootTest
class ElasticsearchApplicationTests {
	
	@Autowired
	private BookRepositoryDAO bookRepositoryDAO;;
	
	@Test
	void contextLoads() {
		
		System.out.println("Hello Test case passes successfully");
	}
	
	@Test
	void updateSingleRecord() {
		bookRepositoryDAO.updateQuery("Book2006");
		System.out.print("***********Update***************");
	}
	
}
