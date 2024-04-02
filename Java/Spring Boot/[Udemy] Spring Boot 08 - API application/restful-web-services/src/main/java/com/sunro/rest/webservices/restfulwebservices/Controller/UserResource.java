package com.sunro.rest.webservices.restfulwebservices.Controller;

import com.sunro.rest.webservices.restfulwebservices.service.UserDaoService;
import com.sunro.rest.webservices.restfulwebservices.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    //GET /users
    @GetMapping("/users")
    public List<User> retriveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public EntityModel<User> retriveOneUsers(@PathVariable(value = "id")int id){
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        System.out.println("수신");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteBUser(@PathVariable("id") int id) {
        service.deleteById(id);

    }

}
