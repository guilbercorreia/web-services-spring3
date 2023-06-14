package com.projetowebservices.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetowebservices.demo.entities.Order;
import com.projetowebservices.demo.entities.User;
import com.projetowebservices.demo.entities.enums.OrderStatus;
import com.projetowebservices.demo.repositories.OrderRepository;
import com.projetowebservices.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Estevão Ferreia", "estevao.f@gmail.com", "88888888", "12345678");
		User u2 = new User(null, "Alex Marques", "alex.m@gmail.com", "77777777", "12345678");
		Order o1 = new Order(null, Instant.parse("2023-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
		Order o2 = new Order(null, Instant.parse("2023-06-21T03:42:10Z"), u2, OrderStatus.CANCELED);
		Order o3 = new Order(null, Instant.parse("2023-06-22T15:21:22Z"), u1 , OrderStatus.DELIVERED);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
