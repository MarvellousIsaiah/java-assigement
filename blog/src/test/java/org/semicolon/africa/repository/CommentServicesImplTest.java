package org.semicolon.africa.repository;

import org.junit.jupiter.api.Test;
import org.semicolon.africa.dtos.*;
import org.semicolon.africa.repository.Comments;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.semicolon.africa.repository.Views;
import org.semicolon.africa.services.CommentServicesImpl;
import org.semicolon.africa.services.PostServices;
import org.semicolon.africa.services.UserServicesImpl;
import org.semicolon.africa.services.ViewServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentServicesImplTest {


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
    @Autowired
    private CommentServicesImpl commentServices;
    @Autowired
    private Comments comments;
    @Test
    public void testThatCommentAreSavedToPost() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very hard");
        registerRequest.setLastName("very very hard");
        userServices.signUp(registerRequest);
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setUserName("semicolon");
        logInRequest.setPassword("hard");
        userServices.logIn(logInRequest);
        posts.deleteAll();
        PostRequest postRequest = new PostRequest();
        postRequest.setPosterUserName("semicolon");
        postRequest.setContent("very very  hard");
        postRequest.setTitle("semicolon is hard");
        postServices.createPost(postRequest);
        assertEquals(postServices.getAllPostsOf("semicolon").size(), 1);
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setContentToView("very very  hard");
        viewRequest.setViewerUserName("semicolon");
        viewServices.viewPosts(viewRequest);
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("hard things");
        commentRequest.setPostContent("very very  hard");
        commentRequest.setCommenterUserName("semicolon");
        commentServices.commentToPost(commentRequest);
        assertEquals(posts.findPostByContent("very very  hard").getComments().size(),1 );
    }

    @Test
   public void testThatCommentCanBeDeleted() {
        users.deleteAll();
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUserName("semicolon");
        registerRequest.setPassword("hard");
        registerRequest.setFirstName("very hard");
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
        assertEquals(postServices.getAllPostsOf("semicolon").size(), 1);
        ViewRequest viewRequest = new ViewRequest();
        viewRequest.setContentToView("hard");
        viewRequest.setViewerUserName("semicolon");
        viewServices.viewPosts(viewRequest);
        comments.deleteAll();
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setComment("hard things");
        commentRequest.setPostContent("hard");
        commentServices.commentToPost(commentRequest);
        commentServices.deleteCommentBy(commentRequest);
        assertEquals(posts.findPostByContent("hard").getViews().size(), 1);
        assertEquals(posts.findPostByContent("hard").getComments().size(),0 );

   }
}