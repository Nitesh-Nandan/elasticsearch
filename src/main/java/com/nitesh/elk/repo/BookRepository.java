package com.nitesh.elk.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.nitesh.elk.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, String>{
	
	
//	@Transactional
//	@Query(value="UPDATE book set author=:author where id=:id", nativeQuery = true)
//	public void updateAuthorById(@Param("id") int id,@Param("author") String author);
//	

}
