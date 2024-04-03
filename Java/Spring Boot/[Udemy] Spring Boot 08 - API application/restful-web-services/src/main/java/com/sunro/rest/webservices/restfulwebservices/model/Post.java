package com.sunro.rest.webservices.restfulwebservices.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sunro.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2)
    private String Description;

    @ManyToOne(fetch = LAZY)
    @JsonIgnore
    private User user;


}
