package org.semicolon.africa.services;


import org.semicolon.africa.data.models.User;
import org.semicolon.africa.dtos.LogInRequest;
import org.semicolon.africa.dtos.LogInResponse;
import org.semicolon.africa.dtos.RegisterRequest;
import org.semicolon.africa.dtos.RegisterResponse;

public interface UserServices {
    RegisterResponse signUp (RegisterRequest registerRequest);
    LogInResponse logIn(LogInRequest logInRequest);
    LogInResponse logOut(LogInRequest logInRequest);
    User findUserByUserName(String userName);
}
