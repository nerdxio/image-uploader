package com.example.imageuploder.product;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/todo")
@CrossOrigin
public class TodoController {

    @GetMapping
    List<Todo> getAllTodo() {
        return List.of(
                new Todo(
                        1L,
                        1L,
                        "todo 1"
                ),
                new Todo(
                        2L,
                        1L,
                        "todo 2"
                ),
                new Todo(
                        3L,
                        1L,
                        "todo 3"
                )
        );
    }

    record Todo(Long id, Long userId, String title) {
    }
}
