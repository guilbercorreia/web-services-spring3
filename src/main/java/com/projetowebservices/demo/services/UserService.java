package com.projetowebservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetowebservices.demo.entities.User;
import com.projetowebservices.demo.repositories.UserRepository;
import com.projetowebservices.demo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository Repository;

	public List<User> findAll() {
		return Repository.findAll();
	}

	public User findById(long id) {
		Optional<User> obj = Repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User obj) {
		return Repository.save(obj);
	}

	public void delete(Long id){
		Repository.deleteById(id);
	}
	
	public User update(Long id, User obj){
		User entity = Repository.getReferenceById(id);
		updateData(entity, obj);
		return Repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
