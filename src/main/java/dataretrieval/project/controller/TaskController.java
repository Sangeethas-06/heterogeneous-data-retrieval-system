package dataretrieval.project.controller;

import dataretrieval.project.model.Task;
import dataretrieval.project.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;
    @PostMapping("/api/tasks")
    public ResponseEntity<Task> createTaskForDevice(@RequestParam String deviceId) {
        Task task = taskService.createTaskForDevice(deviceId);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }
}
