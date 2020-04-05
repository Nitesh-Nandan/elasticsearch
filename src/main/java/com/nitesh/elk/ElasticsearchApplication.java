package com.nitesh.elk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nitesh.elk.loader.InsertBulkLoader;
import com.nitesh.elk.loader.InsertLoaderService;
import com.nitesh.elk.loader.UpdateLoader;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {
	
	
	@Autowired
	private InsertLoaderService inserLoaderService;
	
	@Autowired
	private InsertBulkLoader insertBulkLoader;
	
	@Autowired
	private UpdateLoader updateLoader;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
	
	
	private void collectInsertionStatsOneByOne() {
		var currentId = 1;
		var records = 10;
		
		long ttime = 0;
		var trecord =0;
		
		while(records<100000) {
			ttime+=inserLoaderService.innsertRecord(currentId, records);
			trecord+=records;
			currentId+=records;
			records*=10;
		}
		
		System.out.println("Avg insertion rate is " + ((trecord*1000)/ttime) + " insertion/sec");
	}
	
	
	private void collectInsertionStatsInChunk() {
		int totalRecords = 10000;
		int chunkSize = 500;
		
		int startId = 1;
		
		for(int x= chunkSize;x<=3000;x+=chunkSize) {
			long ttime = 0;
			System.out.println("Inseting Records in chunk of " + x +  " ...........");
			ttime = insertBulkLoader.insertDatainChunk(totalRecords, x, startId);
			startId+=totalRecords;
			System.out.println("Avg bulk insertion time in chunk of " + x + "is " + ((totalRecords*1000)/ttime)+ " insetion/sec");
			System.out.println("Finished ...........");
		}
		
		
	}
	
	private void collectStatsForUpdate() {
		
		int record = 1000;
		while(record<=100000) {
			System.out.println("Updating "+ record + " ....");
			updateLoader.updateRecords(record);
			
			if(record<10000) {
				record+=1000;
			}
			else {
				record+=10000;
			}
		}
		System.out.println("Finished...");
		
	}



	@Override
	public void run(String... args) throws Exception {
//		collectInsertionStatsOneByOne();
//		collectInsertionStatsInChunk();
		
		inserLoaderService.innsertRecord(1, 10000);
	}

}