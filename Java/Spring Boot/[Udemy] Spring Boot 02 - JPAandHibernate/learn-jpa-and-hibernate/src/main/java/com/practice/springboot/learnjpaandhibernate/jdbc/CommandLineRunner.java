package com.practice.springboot.learnjpaandhibernate.jdbc;

import com.practice.springboot.learnjpaandhibernate.jdbc.repository.CourseJpaRepository;
import com.practice.springboot.learnjpaandhibernate.jdbc.repository.SpringDataJpaRepository;
import com.practice.springboot.learnjpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Spring Application 시작시 실행될 로직이 있을 때 사용한다.
 */
@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

//    @Autowired
//    private jdbcRepository repository;
//
//    @Autowired
//    private CourseJpaRepository jpaRepository;

    @Autowired
    private SpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
//        repository.insertv2(new Course(2L,"new sunro","new sunro"));
//            repository.delete(1L);
//        System.out.println(repository.select( 2L));

//        repository.insert(new Course(1L, "test" , "tt"));
//        repository.findById(1L);
//        repository.deleteById(1L);


        //SpringDataJPA는 save를 사용한다. 또한 동사by필드명으로 사용가능하다.
        repository.save(new Course(1L, "test" , "tt"));
        repository.findById(1L);
        repository.deleteById(1L);
        System.out.println("\t ========= \t");
        repository.save(new Course(4L, "LeeSunRo", "sunro"));
        System.out.println("\t ========= \t");
        repository.findByAuthor("sunro");
        List<Course> courseList= repository.findByName("LeeSunRo");

        System.out.println(courseList);
        repository.findAll();

    }




}
