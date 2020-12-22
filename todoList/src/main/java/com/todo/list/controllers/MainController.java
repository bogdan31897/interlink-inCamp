package com.todo.list.controllers;

import java.util.HashMap;
import java.util.List;
import com.todo.list.resources.Task;
import com.todo.list.resources.Tasks;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {


    @PostMapping("/tasks")
    @ResponseBody
    public Task addTask(@RequestBody Task task) {
        return Tasks.add(task);
    }

    @GetMapping("/tasks")
    public HashMap<Long,Task> printTasks() {
        return Tasks.getTasks();
    }

    @ResponseBody
    @PutMapping("/tasks")
    public Task updateTask(@RequestBody Task task, @RequestParam(value = "id", defaultValue = "0") long id) {
        return Tasks.update(id, task);
    }

    @DeleteMapping("/tasks")
    public Task removeTask(@RequestParam(value = "id", defaultValue = "0") int id) {
        return Tasks.remove(id);
    }

}
