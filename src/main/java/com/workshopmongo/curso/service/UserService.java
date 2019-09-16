package com.workshopmongo.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.curso.domain.User;
import com.workshopmongo.curso.dto.UserDTO;
import com.workshopmongo.curso.repository.UserRepository;
import com.workshopmongo.curso.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		
		return this.repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public void delete(String id) {
		this.findById(id);
		this.repository.deleteById(id);
	}
	
	
	public User update(User obj) {
		User newObj = this.findById(obj.getId());
		
		updateData(newObj, obj);
		
		return this.repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	
	public User insert(User obj) {
		
		return this.repository.save(obj);
	}
	
	public User formDto(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail()); 
	}

}
