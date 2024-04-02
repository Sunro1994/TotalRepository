package com.sunro.rest.webservices.restfulwebservices.Controller;

import com.sunro.rest.webservices.restfulwebservices.repository.UserRepository;
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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    @Autowired
    private UserDaoService service;

    @Autowired
    private UserRepository userRepository;

    public UserJpaResource(UserDaoService service, UserRepository userRepository) {

        this.service = service;
        this.userRepository = userRepository;
    }

    //GET /users
    @GetMapping("/jpa/users")
    public List<User> retriveAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retriveOneUsers(@PathVariable(value = "id")int id){
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }

        if (user == null) {
            throw new UserNotFoundException("id" + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        System.out.println("수신");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteBUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);

    }

}
