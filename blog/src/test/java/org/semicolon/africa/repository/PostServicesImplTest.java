package org.semicolon.africa.repository;

import org.junit.jupiter.api.Test;
import org.semicolon.africa.dtos.LogInRequest;
import org.semicolon.africa.dtos.PostRequest;
import org.semicolon.africa.dtos.RegisterRequest;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.semicolon.africa.services.PostServices;
import org.semicolon.africa.services.UserServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class PostServicesImplTest {

    @Autowired
    private PostServices postServices;
    @Autowired
    private Posts posts;
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private Users users;
    @Test
    public void testThatPostCAnBeCreated() {
         users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very very hard");
        registerRequest.setLastName("life hard");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("semicolon");
        logInRequest.setPassword("hard");
        userServices.logIn(logInRequest);
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("semicolon");
        postRequest.setContent("hard boy");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(),1);

    }

    @Test
    public void testThatWeCanGetAllUserPost() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very very hard");
        registerRequest.setLastName("life hard");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("semicolon");
        logInRequest.setPassword("hard");
        userServices.logIn(logInRequest);
        posts.deleteAll();
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("semicolon");
        postRequest.setContent("hard things");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(),1);
    }

    @Test
    public void testGetAllPostsForUser() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very very hard");
        registerRequest.setLastName("life hard");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("semicolon");
        logInRequest.setPassword("hard");
        userServices.logIn(logInRequest);
        posts.deleteAll();
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("semicolon");
        postRequest.setContent("hard");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(),1);
    }

    @Test
    public void testDeletePostBy() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very very hard");
        registerRequest.setLastName("life hard");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("semicolon");
        logInRequest.setPassword("hard");
        userServices.logIn(logInRequest);
        posts.deleteAll();
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("semicolon");
        postRequest.setContent("everything hard");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        postServices.deletePostBy(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(),0);

    }
}