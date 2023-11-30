package dataretrieval.project.service;

import dataretrieval.project.model.Task;
import dataretrieval.project.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTaskForDevice(String deviceId){
        Task task= Task.builder()
                .deviceId(deviceId)
                .status("TO_DO")
                .build();
        return taskRepository.save(task);
    }
}
