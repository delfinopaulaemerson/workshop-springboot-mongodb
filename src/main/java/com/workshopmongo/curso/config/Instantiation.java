package com.workshopmongo.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopmongo.curso.domain.Post;
import com.workshopmongo.curso.domain.User;
import com.workshopmongo.curso.dto.AuthorDTO;
import com.workshopmongo.curso.repository.PostRepository;
import com.workshopmongo.curso.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yy");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		this.userRepository.deleteAll();
		
		this.postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		this.userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 =  new Post(null, df.parse("21/003/2018"), "partiu viagem", "vou viajar a são paulo. abraços!", new AuthorDTO(maria));
		Post post2=  new Post(null, df.parse("23/03/2018"), "Bom Dia", "acordei feliz hoje!",new AuthorDTO(maria));
		this.postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		this.userRepository.save(maria);
		
	}

}
