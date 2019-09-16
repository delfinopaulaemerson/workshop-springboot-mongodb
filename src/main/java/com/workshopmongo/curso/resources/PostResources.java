package com.workshopmongo.curso.resources;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshopmongo.curso.domain.Post;
import com.workshopmongo.curso.resourceses.util.Url;
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
	
	@RequestMapping(value="/titlesearch",method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitleContainingIgnoreCase(@RequestParam(value = "text",defaultValue = "") String text){
		List<Post> lista = new ArrayList<Post>();
		String texto = Url.decodeParam(text);
		
		lista = this.service.searchTitle(texto);
		
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/fullsearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> fullSearch(
 			@RequestParam(value="text", defaultValue="") String text,
 			@RequestParam(value="minDate", defaultValue="") String minDate,
 			@RequestParam(value="maxDate", defaultValue="") String maxDate) {
		text = Url.decodeParam(text);
		Date min = Url.convertDate(minDate, new Date(0L));
		Date max = Url.convertDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min, max);
		
		return ResponseEntity.ok().body(list);
	}
	
	
	

}
