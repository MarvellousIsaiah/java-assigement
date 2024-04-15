package org.semicolon.africa.services;


import org.semicolon.africa.data.models.View;
import org.semicolon.africa.dtos.ViewRequest;
import org.semicolon.africa.dtos.ViewResponse;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.semicolon.africa.repository.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.semicolon.africa.utils.Mappers.mapViewRequestToResponse;

@Service
public class ViewServicesImpl implements ViewServices{

    @Autowired
    private Views views;

    @Autowired
     private Posts posts;

    @Autowired
    private Users users;

    public ViewResponse viewPosts(ViewRequest viewRequest){
        View view = new View();
        viewRequest.setTimeOfView(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        var post = posts.findPostByContent(viewRequest.getContentToView());
        view.setViewerUserName(users.findUserByUserName(viewRequest.getViewerUserName()).getUserName());
        view.setTimeOfView(viewRequest.getTimeOfView());
        views.save(view);
        post.getViews().add(view);
        posts.save(post);
        var user = users.findUserByUserName(post.getPosterUserName());
        user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
        users.save(user);
        return mapViewRequestToResponse(viewRequest);
    }
}
