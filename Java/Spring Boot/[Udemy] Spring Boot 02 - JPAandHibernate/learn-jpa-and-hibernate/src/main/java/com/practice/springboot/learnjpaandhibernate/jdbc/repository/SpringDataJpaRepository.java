package com.practice.springboot.learnjpaandhibernate.jdbc.repository;

import com.practice.springboot.learnjpaandhibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//인터페이스임을 주의하자
@Repository
public interface SpringDataJpaRepository extends JpaRepository<Course, Long> {


    //기본적으로 제공하는 것 이외에 커스텀하기
    List<Course> findByAuthor(String author);


    List<Course> findByName(String name);
}
