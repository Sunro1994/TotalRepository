package com.sunro.rest.webservices.restfulwebservices.repository;

import com.sunro.rest.webservices.restfulwebservices.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
