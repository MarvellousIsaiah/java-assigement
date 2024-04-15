package org.semicolon.africa.repository;


import org.junit.jupiter.api.Test;
import org.semicolon.africa.dtos.LogInRequest;
import org.semicolon.africa.dtos.PostRequest;
import org.semicolon.africa.dtos.RegisterRequest;
import org.semicolon.africa.dtos.ViewRequest;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.semicolon.africa.repository.Views;
import org.semicolon.africa.services.PostServices;
import org.semicolon.africa.services.UserServicesImpl;
import org.semicolon.africa.services.ViewServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class ViewServicesImplTest {
    @Autowired
    private PostServices postServices;
    @Autowired
    private Posts posts;
    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private Users users;
    @Autowired
    private Views views;
    @Autowired
    private ViewServicesImpl viewServices;

    @Test
    public void testThatPostCanBeViewed() {
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
        postRequest.setContent("hard boy");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(), 1);
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setContentToView("hard boy");
        viewRequest.setViewerUserName("semicolon");
        viewServices.viewPosts(viewRequest);
        assertEquals(posts.findPostByContent("hard boy").getViews().size(), 1);
    }
}