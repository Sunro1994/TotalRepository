package com.Security.Security6Practice.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class TodoController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODO_LIST = List.of(new Todo("sunro", "Learn AWS"),
            new Todo("sunro", "Learn Java"));

    @GetMapping("/todos")
    public List<Todo> retrieveTodos() {
        return TODO_LIST;
    }

    @GetMapping("/todos/{username}")
    public Todo retrieveTodosForSpecificUser(@PathVariable(value = "username") String username) {

        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoSpecificUser(@PathVariable(value = "username") String username,
                                       @RequestBody Todo todo) {
        logger.info("Create {} for {}",todo,username);

    }
}

    record Todo(String username, String desciption) {

    }
