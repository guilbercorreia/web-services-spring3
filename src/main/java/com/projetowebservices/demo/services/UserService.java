package com.projetowebservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetowebservices.demo.entities.User;
import com.projetowebservices.demo.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository Repository;

	public List<User> findAll(){
		return Repository.findAll();
	}
	public User findById(long id){
		Optional<User> obj = Repository.findById(id);
		return obj.get(); 
	
}
}
