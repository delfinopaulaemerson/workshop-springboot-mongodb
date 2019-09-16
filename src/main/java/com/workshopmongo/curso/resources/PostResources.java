package com.workshopmongo.curso.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshopmongo.curso.domain.Post;
import com.workshopmongo.curso.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {
	
	@Autowired
	private PostService service;
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post post = new Post();
		
		post = this.service.findById(id);
		
		return ResponseEntity.ok().body(post);
	}
	
	

}
