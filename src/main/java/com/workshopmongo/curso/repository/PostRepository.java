package com.workshopmongo.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshopmongo.curso.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}