package com.practice.springboot.learnjpaandhibernate.jdbc.repository;

import com.practice.springboot.learnjpaandhibernate.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseJpaRepository {

    @PersistenceContext //무슨 어노테이션?
    private EntityManager em;

@Transactional
    public void insert(Course course) {
        em.merge(course);
    }

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        Course course = em.find(Course.class, id);
        em.remove(course);
    }
}
