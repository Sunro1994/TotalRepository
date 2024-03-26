package com.practice.springboot.learnjpaandhibernate.jdbc;

import com.practice.springboot.learnjpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Spring Application 시작시 실행될 로직이 있을 때 사용한다.
 */
@Component
public class JdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    jdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insertv2(new Course(2L,"new sunro","new sunro"));
//            repository.delete(1L);
        System.out.println(repository.select( 2L));

    }




}
