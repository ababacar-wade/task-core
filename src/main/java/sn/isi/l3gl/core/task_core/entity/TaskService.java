package sn.isi.l3gl.core.task_core.entity;

import sn.isi.l3gl.core.task_core.enumeration.StatusEnum;
import sn.isi.l3gl.core.task_core.repository.TaskRepository;

import java.util.List;

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

    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    public Task updateStatus(int id, StatusEnum newStatus) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    public long countCompletedTasks() {
        return taskRepository.countByStatus(StatusEnum.DONE);
    }
}
