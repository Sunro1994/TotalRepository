package com.sunro.rest.webservices.restfulwebservices.user;


import com.sunro.rest.webservices.restfulwebservices.model.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "user_details")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min=2, message = "Name shoudl have at least 2 characters") //최소 2글자
    private String name;
    @Past(message = "Birth Date should be in the past")  //항상 과거의 날짜로 설정되게 추가하기
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public User(){

    }
    public User(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
