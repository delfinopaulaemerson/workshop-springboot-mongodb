package com.workshopmongo.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.curso.domain.Post;
import com.workshopmongo.curso.repository.PostRepository;
import com.workshopmongo.curso.service.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	

	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitleContainingIgnoreCase(String text ){
		
		return this.postRepository.findByTitleContainingIgnoreCase(text);
	}
	
}
