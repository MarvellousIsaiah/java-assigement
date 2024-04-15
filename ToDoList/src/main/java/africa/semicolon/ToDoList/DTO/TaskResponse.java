package africa.semicolon.ToDoList.DTO;
import africa.semicolon.ToDoList.data.model.Status;
import africa.semicolon.ToDoList.data.model.TaskPriority;
import africa.semicolon.ToDoList.services.TaskServices;
import lombok.Data;
import java.time.LocalDateTime;

import static africa.semicolon.ToDoList.data.model.Status.UNCOMPLETED;

@Data
public class TaskResponse {
    private String task;
    private LocalDateTime timeCompleted;
    private LocalDateTime timeCreated;
    private LocalDateTime timeStarted;
    private String taskAuthor;
    private Status status = UNCOMPLETED;
    private TaskPriority priority;
}
