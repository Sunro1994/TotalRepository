package com.practice.springboot.learnjpaandhibernate.jdbc;

import com.practice.springboot.learnjpaandhibernate.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class jdbcRepository {

    @Autowired
    private JdbcTemplate springJdbctemplate;

    public void insertv1() {
        springJdbctemplate.update("insert into mocktable(id,name,author) values(1,'sunro','sunro')");
    }

    public void insertv2(Course course){
        springJdbctemplate.update("insert into mocktable(id,name,author) values(?,?,?)"
                ,course.getId()
                ,course.getName()
                ,course.getAutrhor());
    }

    public void delete(Long id) {
        springJdbctemplate.update("delete from mocktable where id=?", id);
    }

    public Course select(Long id) {
        return springJdbctemplate.queryForObject("select * from mocktable where id=?", new BeanPropertyRowMapper<>(Course.class), id);
    }
}
