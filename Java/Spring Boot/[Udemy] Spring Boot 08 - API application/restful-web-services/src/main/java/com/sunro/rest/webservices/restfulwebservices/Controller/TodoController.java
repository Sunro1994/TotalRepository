package com.sunro.rest.webservices.restfulwebservices.Controller;

import com.sunro.rest.webservices.restfulwebservices.model.Todo;
import com.sunro.rest.webservices.restfulwebservices.repository.TodoRepository;
import com.sunro.rest.webservices.restfulwebservices.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    private TodoRepository todoRepository;


    @GetMapping("/users/{username}/todos")
    public List<Todo> retriveTodos(@PathVariable("username") String username) {
        return todoRepository.findByUsername(username);
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
    @PutMapping("/users/{username}/todos/{id}")
    public Todo updateTodo(
            @PathVariable(value = "username") String username,
            @PathVariable(value = "id") int id,
            @RequestBody Todo todo) {
         todoService.updateTodo(todo);
        return todo;
    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(
            @PathVariable(value = "username") String username,
            @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId(null);
        todo.setDone(false);
        System.out.println(todo.getUsername());
        System.out.println(todo.getDescription());
        System.out.println(todo.getTargetDate());
        return todoRepository.save(todo);
    }
}
