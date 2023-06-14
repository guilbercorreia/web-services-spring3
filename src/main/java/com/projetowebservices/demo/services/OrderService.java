package com.projetowebservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetowebservices.demo.entities.Order;
import com.projetowebservices.demo.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository Repository;

	public List<Order> findAll() {
		return Repository.findAll();
	}

	public Order findById(long id) {
		Optional<Order> obj = Repository.findById(id);
		return obj.get();

	}
}
