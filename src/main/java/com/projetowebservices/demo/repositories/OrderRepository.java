package com.projetowebservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservices.demo.entities.Order;

public interface OrderRepository extends JpaRepository <Order, Long>{

}
