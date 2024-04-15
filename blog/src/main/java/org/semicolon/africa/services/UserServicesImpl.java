package org.semicolon.africa.services;


import org.semicolon.africa.Exceptions.UserAlreadyExistException;
import org.semicolon.africa.Exceptions.UserNotFoundException;
import org.semicolon.africa.data.models.User;
import org.semicolon.africa.dtos.LogInRequest;
import org.semicolon.africa.dtos.LogInResponse;
import org.semicolon.africa.dtos.RegisterRequest;
import org.semicolon.africa.dtos.RegisterResponse;
import org.semicolon.africa.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.semicolon.africa.utils.Mappers.*;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private Users users;

    @Override
    public RegisterResponse signUp(RegisterRequest registerRequest) {
        User user = new User();
        mapRequestToUser(registerRequest,user);
        if (isValid(user))users.save(user);
        else throw new UserAlreadyExistException("user already exist");
        return mapUserToRegisterResponse(user);
    }

    @Override
    public LogInResponse logIn(LogInRequest logInRequest) {
           LogInResponse logInResponse = new LogInResponse();
           var user = findUserByUserName(logInRequest.getUserName());
        if(user.getPassword().equalsIgnoreCase(logInRequest.getPassword())) user.setLoggedIn(true);
        else throw new UserNotFoundException("you are not a valid user !!");
        users.save(user);
        return mapLogInRequestToResponse(user,logInResponse);
    }

    private boolean isValid(User user) {
        return users.findUserByUserName(user.getUserName()) == null;
    }

    public User findUserByUserName(String userName)
    {return users.findUserByUserName(userName);}


    @Override
    public LogInResponse logOut(LogInRequest logInRequest) {
        LogInResponse logInResponse = new LogInResponse();
        var user = findUserByUserName(logInRequest.getUserName());
        if(user.isLoggedIn()) user.setLoggedIn(false);
        else throw new UserAlreadyExistException("you are logged out already");
        users.save(user);
        return mapLogInRequestToResponse(user,logInResponse);
    }



}