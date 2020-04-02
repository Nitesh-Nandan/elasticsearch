package com.nitesh.elk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nitesh.elk.loader.InsertBulkLoader;
import com.nitesh.elk.loader.InsertLoaderService;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {
	
	
	@Autowired
	private InsertLoaderService inserLoaderService;
	
	@Autowired
	private InsertBulkLoader insertBulkLoader;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
	
	
	private void collectInsertionStatsOneByOne() {
		var currentId = 1;
		var records = 10;
		
		while(records<100000) {
			inserLoaderService.innsertRecord(currentId, records);
			currentId+=records;
			records*=10;
		}
	}
	
	
	private void collectInsertionStatsInChunk() {
		int totalRecords = 10000;
		int chunkSize = 500;
		
		int startId = 1;
		
		for(int x= chunkSize;x<=3000;x+=chunkSize) {
			System.out.println("Inseting Records in chunk of " + x +  " ...........");
			insertBulkLoader.insertDatainChunk(totalRecords, x, startId);
			startId+=totalRecords;
			System.out.println("Finished ...........");
		}
		
		
	}


	@Override
	public void run(String... args) throws Exception {
//		collectInsertionStatsOneByOne();
		collectInsertionStatsInChunk();
	}

}