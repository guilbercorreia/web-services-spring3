package com.projetowebservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetowebservices.demo.entities.Product;
import com.projetowebservices.demo.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository Repository;

	public List<Product> findAll(){
		return Repository.findAll();
	}
	public Product findById(long id){
		Optional<Product> obj = Repository.findById(id);
		return obj.get(); 
	
}
}
