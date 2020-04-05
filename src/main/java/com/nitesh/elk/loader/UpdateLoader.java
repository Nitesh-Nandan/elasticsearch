package com.nitesh.elk.loader;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;

import com.nitesh.elk.repo.BookRepository;
import com.nitesh.elk.service.BookRepositoryImpl;

//@Service
public class UpdateLoader {

	@Autowired
	private BookRepositoryImpl bookRepositoryImpl;

	@Autowired
	private BookRepository bookRepository;

	public void updateRecords(int limit) {

		long start1 = System.currentTimeMillis();

		for (int i = 0; i < limit; i++) {
			var id = ThreadLocalRandom.current().nextInt(1, 100000);
			bookRepositoryImpl.updateQuery("Book2006");
		}
		long end1 = System.currentTimeMillis();
		long elapsedTime = end1 - start1;

		System.out.println("Time taken to update " + limit + " record is " + elapsedTime + " millis");

	}

}
