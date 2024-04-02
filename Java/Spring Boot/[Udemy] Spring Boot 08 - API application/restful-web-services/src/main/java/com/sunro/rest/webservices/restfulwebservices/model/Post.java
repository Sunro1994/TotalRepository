package com.sunro.rest.webservices.restfulwebservices.model;

import com.sunro.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String Description;

    @ManyToOne
    private User user;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", Description='" + Description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public Post(Integer id, String description) {
        this.id = id;
        Description = description;
    }
}
