package africa.semicolon.ToDoList.controllers;

import africa.semicolon.ToDoList.DTO.LogginRequest;
import africa.semicolon.ToDoList.DTO.LoggoutRequest;
import africa.semicolon.ToDoList.DTO.SignUpRequest;
import africa.semicolon.ToDoList.services.UserServicesImpI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicesController {

    @Autowired
    private UserServicesImpI userServicesImpI;
    @PostMapping("/signup")
    public String signup(@RequestBody SignUpRequest signUpRequest){
        try{
             userServicesImpI.signUp(signUpRequest);
            return  "successfull";
        }catch (RuntimeException exception){
                 return exception.getMessage();
        }
    }

    @PostMapping("/log-in")
    public String logIn(@RequestBody LogginRequest logginRequest){
        try{
             userServicesImpI.LogIn(logginRequest);
             return "you are successfully logged in";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }


    @PostMapping("/log-out")
    public String logOut(@RequestBody LoggoutRequest loggoutRequest){
        try{
            userServicesImpI.logOut(loggoutRequest);
            return "you are successfully logged out";
        }catch (RuntimeException exception){
            return exception.getMessage();
        }
    }




}
