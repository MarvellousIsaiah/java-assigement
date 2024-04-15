package africa.semicolon.ToDoList.DTO;

import africa.semicolon.ToDoList.data.model.Status;
import africa.semicolon.ToDoList.data.model.TaskPriority;
import lombok.Data;

import java.time.LocalDateTime;

import static africa.semicolon.ToDoList.data.model.Status.UNCOMPLETED;

@Data
public class TaskRequest {
    private String task;
    private LocalDateTime timeCompleted;
    private LocalDateTime timeCreated;
    private LocalDateTime timeStarted;
    private String taskAuthor;
    private Status status = UNCOMPLETED;
    private TaskPriority priority;
    private String newTask;
}
