package com.projetowebservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservices.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
