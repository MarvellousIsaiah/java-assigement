package africa.semicolon.ToDoList.data.repositories;

import africa.semicolon.ToDoList.data.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface Tasks extends MongoRepository<Task, String> {
    List<Task> findTasksByTimeCreated(LocalDateTime timeCompleted);
    List<Task> findTasksByTimeDone(LocalDateTime timeDone);
    Task findTasksByTitle(String title);
    List<Task> findTasksByTaskAuthor(String authorName);

}
