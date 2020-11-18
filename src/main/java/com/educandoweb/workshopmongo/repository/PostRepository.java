package com.educandoweb.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.educandoweb.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//Com a declaração abaixo o Query Method do Spring Data monta a consulta pra gente
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//Consulta simples com @Query
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
