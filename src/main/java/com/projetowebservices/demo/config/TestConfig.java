package com.projetowebservices.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservices.demo.entities.User;
import com.projetowebservices.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired	
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Estevão Ferreia", "estevao.f@gmail.com", "88888888", "12345678"); 
		User u2 = new User(null, "Alex Marques", "alex.m@gmail.com", "77777777", "12345678"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
