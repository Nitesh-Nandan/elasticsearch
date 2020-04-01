package com.nitesh.elk.loader;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;

@Service
public class InsertLoaderService {

	@Autowired
	private BookRepository bookRepository;
	
	private String[] authorList = {"nitesh","shreya", "arun" , "charan", "rishi"};
	
	
	public void innsertRecord(int startId, int size) {
		
		
		System.out.println("Inserting the Records .... ");
		
		long start1 = System.currentTimeMillis();
		var limit = startId+size;
		Random rd = new Random();
		
		for(int i=startId;i<limit;i++) {
			var book = new Book(i+"",
					i, "book"+i, authorList[i%authorList.length],"publ"+i, 
					rd.nextFloat()*100, "India"+i );
			bookRepository.save(book);
		}
		
		long end1 = System.currentTimeMillis();
		
		long elapsedTime = end1 - start1;
		
		System.out.println("Time taken to Insert record size of " + size + " is: " + elapsedTime + "milis");
		
		
		System.out.println("********Finished******** ");
	}
}
