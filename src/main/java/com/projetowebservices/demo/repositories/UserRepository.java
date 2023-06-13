package com.projetowebservices.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetowebservices.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
