package com.projetowebservices.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetowebservices.demo.entities.Category;
import com.projetowebservices.demo.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository Repository;

	public List<Category> findAll() {
		return Repository.findAll();
	}

	public Category findById(long id) {
		Optional<Category> obj = Repository.findById(id);
		return obj.get();
	}
}
