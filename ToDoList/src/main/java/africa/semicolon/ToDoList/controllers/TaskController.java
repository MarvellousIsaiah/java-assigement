package africa.semicolon.ToDoList.controllers;

import africa.semicolon.ToDoList.DTO.TaskRequest;
import africa.semicolon.ToDoList.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Autowired
    private TaskServices taskServices;
    @PostMapping("/create")
    public String create(@RequestBody TaskRequest taskRequest){
        try{
            taskServices.createTask(taskRequest);
            return  "successful";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }


    @PostMapping("/update")
    public String update(@RequestBody TaskRequest updateRequest){
        try{
            taskServices.updateTask(updateRequest);
            return  "successful";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }


    @PostMapping("/delete")
    public String signup(@RequestBody TaskRequest deleteRequest){
        try{
            taskServices.deleteTask(deleteRequest);
            return  "successfull";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }



}
