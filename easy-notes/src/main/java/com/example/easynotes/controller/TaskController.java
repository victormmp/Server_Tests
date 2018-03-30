package com.example.easynotes.controller;

import com.example.easynotes.model.Task;
import com.example.easynotes.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	

    @Autowired
    TaskRepository taskRepository;

    // Get All Tasks
    @CrossOrigin(origins = "http://localhost:3000")
    //@CrossOrigin(origins = "http://localhost:")
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Create a new Task
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Get a Single Note
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId) {
        Task task = taskRepository.findOne(taskId);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(task);
    }

    // Update a Note
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateNote(@PathVariable(value = "id") Long taskId, 
                                           @Valid @RequestBody Task taskDetails) {
        Task task = taskRepository.findOne(taskId);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }
        task.setContent(taskDetails.getContent());
        task.setCompletado(taskDetails.getCompletado());
        
        //task.setTitle(taskDetails.getTitle());
        //task.setContent(taskDetails.getContent());

        Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    // Delete a Note
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable(value = "id") Long taskId) {
        Task task = taskRepository.findOne(taskId);
        if(task == null) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.delete(task);
        return ResponseEntity.ok().build();
    }
}