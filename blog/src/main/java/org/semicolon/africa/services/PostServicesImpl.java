package org.semicolon.africa.services;


import org.semicolon.africa.Exceptions.PostDoesNotExistException;
import org.semicolon.africa.Exceptions.UserNotFoundException;
import org.semicolon.africa.data.models.Post;
import org.semicolon.africa.data.models.User;
import org.semicolon.africa.dtos.PostRequest;
import org.semicolon.africa.dtos.PostResponse;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.semicolon.africa.utils.Mappers.mapPostToResponse;
import static org.semicolon.africa.utils.Mappers.mapRequestToPost;

@Service
public class PostServicesImpl implements PostServices{
    @Autowired
    private Posts posts;

    @Autowired
    private Users users;

    public PostResponse createPost(PostRequest postRequest){
        Post post = new Post();
        postRequest.setTimeCreated(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        var user = users.findUserByUserName(postRequest.getPosterUserName());
        if(user==null)throw new UserNotFoundException("you need to be a valid user to post");
        if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
        mapRequestToPost(postRequest,post);
        user.getPosts().add(post);
        posts.save(post);
        users.save(user);
        return mapPostToResponse(post);
    }


    public List<Post> getAllPostsOf(String userName){
        if(users.findUserByUserName(userName) == null)throw new UserNotFoundException("you need to be a valid user to post");
        if(!users.findUserByUserName(userName).isLoggedIn())throw new UserNotFoundException("you are logged out");
        return getAllPostsFor(users.findUserByUserName(userName));
    }

    public List<Post> getAllPostsFor(User user){
        return user.getPosts();
    }



    public PostResponse deletePostBy(PostRequest postRequest) {
         var user = users.findUserByUserName(postRequest.getPosterUserName());
         var post = posts.findPostByContent(postRequest.getContent());
         if(post == null)throw new PostDoesNotExistException("these post was not created");
         if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
         posts.deletePostById(post.getId());
         posts.delete(post);
         user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
         users.save(user);
         return mapPostToResponse(post);
    }


}
