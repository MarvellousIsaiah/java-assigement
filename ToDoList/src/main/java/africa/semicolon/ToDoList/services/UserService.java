package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.LogginRequest;
import africa.semicolon.ToDoList.DTO.LoggoutRequest;
import africa.semicolon.ToDoList.DTO.SignUpRequest;
import africa.semicolon.ToDoList.data.model.User;

public interface UserService {
 void signUp(SignUpRequest signupRequest);
 void logOut(LoggoutRequest logoutRequest);
 void LogIn(LogginRequest logginrequest);

 User findByUser(String semicolon);
}
