package com.sunro.rest.webservices.restfulwebservices.repository;

import java.util.List;

import com.sunro.rest.webservices.restfulwebservices.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    public List<Todo> findByUsername(String username);
}