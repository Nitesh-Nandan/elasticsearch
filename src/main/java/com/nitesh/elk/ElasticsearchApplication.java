package com.nitesh.elk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nitesh.elk.loader.InsertLoaderService;

@SpringBootApplication
public class ElasticsearchApplication implements CommandLineRunner {
	
	
	@Autowired
	private InsertLoaderService inserLoaderService;

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}
	
	
	private void collectInsertionStats() {
		var currentId = 1;
		var records = 10;
		
		while(records<=100000) {
			inserLoaderService.innsertRecord(currentId, records);
			currentId+=records;
			records*=10;
		}
	}

	@Override
	public void run(String... args) throws Exception {
		collectInsertionStats();
	}

}