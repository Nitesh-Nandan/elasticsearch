package com.nitesh.elk.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nitesh.elk.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{
}
