package com.workshopmongo.curso.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.workshopmongo.curso.domain.User;
import com.workshopmongo.curso.dto.UserDTO;
import com.workshopmongo.curso.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> lista = new ArrayList<User>();
		List<UserDTO> listaDto = new ArrayList<>();
		
		lista = this.service.findAll();
		
		listaDto = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDto);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User user = new User();
		
		user = this.service.findById(id);
		
		return ResponseEntity.ok().body(new UserDTO(user));
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		
		this.service.delete(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO userDTO, @PathVariable String id){
		User obj  = this.service.formDto(userDTO);
		obj.setId(id);
		
		this.service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
		User obj = this.service.formDto(objDTO);
		
		obj = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
