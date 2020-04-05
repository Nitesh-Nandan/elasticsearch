package com.nitesh.elk.service;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import com.nitesh.elk.model.Book;
import com.nitesh.elk.repo.BookRepository;

@Service
public class BookRepositoryImpl implements BookRepositoryDAO {
	
	@Autowired 
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	public void updateQuery(String title) {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
		  .withQuery(QueryBuilders.matchQuery("title", title).minimumShouldMatch("75%"))
		  .build();
		
		List<Book> articles = elasticsearchTemplate.queryForList(searchQuery, Book.class);
		
		
		articles.stream().forEach(temp -> temp.setTitle("Shreya Book"));
		bookRepository.saveAll(articles);
		
	}	
}
