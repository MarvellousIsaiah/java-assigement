package africa.semicolon.ToDoList.Utils;

import africa.semicolon.ToDoList.DTO.*;
import africa.semicolon.ToDoList.data.model.Task;
import africa.semicolon.ToDoList.data.model.User;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Mappers {


        public  static  void mapRequestToTask(TaskRequest taskRequest, Task todoTask){
            todoTask.setTaskAuthor(taskRequest.getTaskAuthor());
            todoTask.setTitle(taskRequest.getTask());
            todoTask.setNewTask(taskRequest.getNewTask());
            todoTask.setTimeCreated(taskRequest.getTimeCreated());
            todoTask.setTimeStarted(taskRequest.getTimeStarted());
            todoTask.setTimeDone(taskRequest.getTimeCompleted());
            todoTask.setTaskStatus(taskRequest.getStatus());
            todoTask.setTaskPriority(taskRequest.getPriority());
        }

        public  static  void mapTaskToRequest(Task todoTask, TaskRequest taskRequest) {
            taskRequest.setTaskAuthor(todoTask.getTaskAuthor());
            taskRequest.setTask(todoTask.getTitle());
            taskRequest.setTimeCreated(todoTask.getTimeCreated());
            taskRequest.setTimeCompleted(todoTask.getTimeDone());
            taskRequest.setPriority(todoTask.getTaskPriority());
            taskRequest.setStatus(todoTask.getTaskStatus());
            taskRequest.setNewTask(todoTask.getNewTask());
            taskRequest.setTimeStarted(todoTask.getTimeStarted());
        }

        public static TaskResponse mapTaskRequestToResponse(TaskRequest taskRequest){
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setTaskAuthor(taskRequest.getTaskAuthor());
            taskResponse.setTimeCreated(taskRequest.getTimeCreated());
            taskResponse.setTask(taskRequest.getTask());
            taskResponse.setTimeCompleted(taskRequest.getTimeCompleted());
            taskResponse.setPriority(taskRequest.getPriority());
            taskResponse.setStatus(taskRequest.getStatus());
            taskResponse.setTimeStarted(taskResponse.getTimeStarted());
            return taskResponse;
        }

        public static TaskResponse mapTaskRequestToResponseUpdate(TaskRequest taskRequest){
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setTaskAuthor(taskRequest.getTaskAuthor());
            taskResponse.setTimeCreated(taskRequest.getTimeCreated());
            taskResponse.setTimeCompleted(taskRequest.getTimeCompleted());
            taskResponse.setTask(taskRequest.getNewTask());
            taskResponse.setPriority(taskRequest.getPriority());
            taskResponse.setStatus(taskRequest.getStatus());
            taskResponse.setTimeStarted(taskRequest.getTimeStarted());
            return taskResponse;
        }

    public static void mapTaskUpdateRequestToTask(TaskRequest taskRequest, Task task){
        task.setTaskAuthor(taskRequest.getTaskAuthor());
        task.setTimeCreated(taskRequest.getTimeCreated());
        task.setTimeDone(taskRequest.getTimeCompleted());
        task.setTitle(taskRequest.getNewTask());
        task.setTaskPriority(taskRequest.getPriority());
        task.setTaskStatus(taskRequest.getStatus());
        task.setTimeStarted(taskRequest.getTimeStarted());
    }


        public static LoginResponse mapUserToResponse(User user){
            LoginResponse todoLogInResponse = new LoginResponse();
            todoLogInResponse.setUserName(user.getUserName());
            todoLogInResponse.setPassword(user.getPassword());
            return todoLogInResponse;
        }

        public static TaskResponse mapTaskToResponse(Task todoTask){
            TaskResponse taskResponse = new TaskResponse();
            taskResponse.setTaskAuthor(todoTask.getTaskAuthor());
            taskResponse.setTask(todoTask.getTitle());
            taskResponse.setTimeCreated(todoTask.getTimeCreated());
            taskResponse.setPriority(todoTask.getTaskPriority());
            taskResponse.setStatus(todoTask.getTaskStatus());
            taskResponse.setTimeCompleted(todoTask.getTimeDone());
            taskResponse.setTimeStarted(todoTask.getTimeStarted());
            return  taskResponse;
        }
        public static void mapRequestToUser(SignUpRequest todoSignUpRequest,User user){
            user.setUserName(todoSignUpRequest.getUserName());
            user.setPassword(todoSignUpRequest.getPassword());
        }

        public static SignupResponse mapSignUpRequestToResponse(SignUpRequest signUpRequest) {
            SignupResponse todoSignUpResponse = new SignupResponse();
            todoSignUpResponse.setUserName(signUpRequest.getUserName());
            return todoSignUpResponse;
        }
    }


