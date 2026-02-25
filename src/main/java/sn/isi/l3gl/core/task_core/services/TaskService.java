package sn.isi.l3gl.core.task_core.services;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.task_core.entity.Task;
import sn.isi.l3gl.core.task_core.enumeration.StatusEnum;
import sn.isi.l3gl.core.task_core.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(String title, String description) {
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setStatus(StatusEnum.TODO);
        return taskRepository.save(task);
    }
}
