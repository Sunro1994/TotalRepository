package com.practice.springboot.learnjpaandhibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "mocktable")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private Long id;

    private String name;
    private String author;
}
