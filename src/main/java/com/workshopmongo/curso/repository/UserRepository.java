package com.workshopmongo.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.workshopmongo.curso.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
