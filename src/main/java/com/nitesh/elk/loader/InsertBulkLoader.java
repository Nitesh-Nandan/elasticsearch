package com.nitesh.elk.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;


@Service
public class InsertBulkLoader {
	
	@Autowired
	private BookRepository bookRepository;
	
	private String[] authorList = {"nitesh","shreya", "arun" , "charan", "rishi"};
	
	
	List<Book> generateDummyObject(int key, int size){
		
		int limit = key+size;
		Random rd = new Random();
		var bookList = new ArrayList<Book>();
		for(int i=key;i<limit;i++) {
			bookList.add( 
					new Book(i,"Book"+i, authorList[i%authorList.length],"publ"+i, 
							rd.nextFloat()*100, "India"+i ));
		}
		
		return bookList;
	}
	
	public void insertDatainChunk(int totalSize, int chunkSize, int startId) {
		if(chunkSize>totalSize) {
			throw new IllegalArgumentException("chunk size can't be greater than total size");
		}
		
		long ttime = 0;
		int inc = chunkSize;
		var tchunk = chunkSize;
		boolean flag = true;
		while(inc<=totalSize && flag) {
			var books =  generateDummyObject(startId,tchunk);
			long start1 = System.currentTimeMillis();
			bookRepository.saveAll(books);
			long end1 = System.currentTimeMillis();
			ttime+=(end1 - start1);
			System.out.println("Record Inserted:  "+ inc);
			flag = (tchunk == chunkSize);
			
			startId+=chunkSize;
			if(inc+chunkSize>totalSize) {
				tchunk = totalSize-inc;
			}
			else {
				inc+=chunkSize;
			}
		}
		
		System.out.println("Time taken to Insert " + totalSize + " in chunk of " + chunkSize + " is "+
		ttime+ " millis");
		
	}

}
