package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.TaskRequest;
import africa.semicolon.ToDoList.DTO.TaskResponse;
import africa.semicolon.ToDoList.data.model.Task;
import africa.semicolon.ToDoList.data.repositories.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static africa.semicolon.ToDoList.Utils.Mappers.*;
import static africa.semicolon.ToDoList.data.model.Status.*;
import static java.time.temporal.ChronoUnit.MINUTES;

@Service
public class TaskServicesImpl implements TaskServices {
    @Autowired
    private Tasks taskRepository;

    @Override
    public Task findTasksByTitle(String title) {
        return taskRepository.findTasksByTitle(title);
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        Task task = new Task();
        taskRequest.setTimeCreated(LocalDateTime.now().truncatedTo(MINUTES));
        mapRequestToTask(taskRequest,task);
        taskRepository.save(task);
        return mapTaskRequestToResponse(taskRequest);
    }

    @Override
    public TaskResponse deleteTask(TaskRequest taskRequest) {
        Task task = findTodoTaskByTask(taskRequest.getTask());
        taskRepository.delete(task);
        return mapTaskRequestToResponse(taskRequest);
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest) {
        Task task = findTasksByTitle(taskRequest.getTask());
        mapTaskUpdateRequestToTask(taskRequest,task);
        taskRepository.save(task);
        return mapTaskRequestToResponseUpdate(taskRequest);
    }

    @Override
    public List<Task> UserTasks(String username) {
        return taskRepository.findTasksByTaskAuthor(username);

    }

    @Override
    public TaskResponse completeTask(TaskRequest taskRequest) {
        Task task = findTasksByTitle(taskRequest.getTask());
        taskRequest.setTimeCompleted(LocalDateTime.now().truncatedTo(MINUTES));
        taskRequest.setStatus(COMPLETED);
        mapRequestToTask(taskRequest,task);
        taskRepository.save(task);
        return mapTaskRequestToResponse(taskRequest);
    }

    @Override
    public TaskResponse startTask(TaskRequest taskRequest) {
        Task task = findTasksByTitle(taskRequest.getTask());
        taskRequest.setTimeStarted(LocalDateTime.now().truncatedTo(MINUTES));
        taskRequest.setStatus(IN_PROGRESS);
        mapRequestToTask(taskRequest,task);
        taskRepository.save(task);
        return mapTaskRequestToResponse(taskRequest);
    }


    @Override
    public List<Task> findAllUserCompletedTasks(String username) {
        var toReturn = new ArrayList<Task>();
         for(var task : taskRepository.findAll())if(task.getTaskStatus()==COMPLETED)toReturn.add(task);
         return toReturn;
    }

    @Override
    public List<Task> findAllIncompletedTask() {
        for(var task : taskRepository.findAll())if(task.getTaskStatus()==UNCOMPLETED)return List.of(task);
        return List.of();
    }

    @Override
    public List<Task> findAllCompletedTasks() {
        var toReturn = new ArrayList<Task>();
        for(var task : taskRepository.findAll())if(task.getTaskStatus()==COMPLETED) toReturn.add(task);
        return toReturn;
    }

    @Override
    public List<Task> findAllUserInCompletedTasks(String username) {
        var toReturn = new ArrayList<Task>();
        for(var task : taskRepository.findAll())if(task.getTaskStatus()==UNCOMPLETED)toReturn.add(task);
        return toReturn;
    }

    @Override
    public List<Task> findAllUserTasks(String username) {
        var toReturn = new ArrayList<Task>();
        for(var task : taskRepository.findAll())if(task.getTaskAuthor().equals(username))toReturn.add(task);
        return toReturn;
    }

    @Override
    public Task findTodoTaskByTask(String task) {
         return taskRepository.findTasksByTitle(task);
    }
}