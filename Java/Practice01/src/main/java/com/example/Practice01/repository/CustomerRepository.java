package com.example.Practice01.repository;

import com.example.Practice01.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<User,Long> {

    List<User> findByName(String username);
}
