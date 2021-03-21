package dev.fenix.application.task.repository;

import dev.fenix.application.task.module.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository  extends PagingAndSortingRepository<Task,Long> {
    Task getTaskById(Long id);
    Task getTaskByTitle(String title);
    Task save(Task task);
    void delete(Task task);
}

