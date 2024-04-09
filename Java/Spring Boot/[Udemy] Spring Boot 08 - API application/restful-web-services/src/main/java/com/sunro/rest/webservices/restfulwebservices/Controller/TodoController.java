package com.sunro.rest.webservices.restfulwebservices.Controller;

import com.sunro.rest.webservices.restfulwebservices.model.Todo;
import com.sunro.rest.webservices.restfulwebservices.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;


    @GetMapping("/users/{username}/todos")
    public List<Todo> retriveTodos(@PathVariable("username") String username) {
        return TodoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(
            @PathVariable(value = "username") String username,
            @PathVariable(value = "id") int id ) {
        return todoService.findById(id);

    }
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> deleteTodo(
            @PathVariable(value = "username") String username,
            @PathVariable(value = "id") int id ) {
         todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
