package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.TaskRequest;
import africa.semicolon.ToDoList.DTO.TaskResponse;
import africa.semicolon.ToDoList.data.model.Task;


import java.util.List;

public interface TaskServices {
    Task findTasksByTitle(String title);
    TaskResponse createTask(TaskRequest taskRequest);

    TaskResponse deleteTask(TaskRequest taskRequest);
    TaskResponse updateTask(TaskRequest taskRequest);
    List<Task> UserTasks(String username);
    TaskResponse completeTask(TaskRequest taskRequest);
   TaskResponse startTask(TaskRequest taskRequest);
   List<Task> findAllUserCompletedTasks(String username);
   List<Task> findAllIncompletedTask();
   List<Task> findAllCompletedTasks();
    List<Task> findAllUserInCompletedTasks(String username);
    List<Task> findAllUserTasks(String username);
    Task findTodoTaskByTask(String task);
}
