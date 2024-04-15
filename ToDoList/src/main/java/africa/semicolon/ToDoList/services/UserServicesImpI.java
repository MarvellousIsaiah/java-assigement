package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.LogginRequest;
import africa.semicolon.ToDoList.DTO.LoggoutRequest;
import africa.semicolon.ToDoList.DTO.SignUpRequest;
import africa.semicolon.ToDoList.data.model.User;
import africa.semicolon.ToDoList.data.repositories.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpI implements UserService {
    @Autowired
    private TaskServicesImpl taskServices;

    @Autowired
    private Users users;

    @Override
    public void signUp(SignUpRequest signupRequest) {
        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setPassword(signupRequest.getPassword());
        users.save(user);
    }

    @Override
    public void logOut(LoggoutRequest logoutRequest) {
        User user = users.findUserByUserName(logoutRequest.getUserName());
        if (user.getUserName().
                equalsIgnoreCase(logoutRequest.getUserName())) user.setActive(false);
        users.save(user);

    }

    @Override
    public void LogIn(LogginRequest logginrequest) {
        User user = users.findUserByUserName(logginrequest.getUserName());
        if (user.getUserName().equalsIgnoreCase
                (logginrequest.getUserName()) && (user.getPassword().
                equalsIgnoreCase(logginrequest.getPassword()))) user.setActive(true);
        users.save(user);


    }

    @Override
    public User findByUser(String username) {
        return users.findUserByUserName(username);
    }


}
