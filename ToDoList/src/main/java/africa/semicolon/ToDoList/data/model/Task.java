package africa.semicolon.ToDoList.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@Document("Tasks")
public class Task {
    @Id
    private String id;
    private String title;
    private LocalDateTime timeCreated;
    private LocalDateTime timeDone;
    private LocalDateTime timeStarted;
    private String taskAuthor;
    private String newTask;
    private Status taskStatus;
    private TaskPriority taskPriority;
}
