package org.semicolon.africa.services;


import org.semicolon.africa.Exceptions.PostDoesNotExistException;
import org.semicolon.africa.Exceptions.UserNotFoundException;
import org.semicolon.africa.data.models.Comment;
import org.semicolon.africa.data.models.Post;
import org.semicolon.africa.data.models.User;
import org.semicolon.africa.dtos.CommentRequest;
import org.semicolon.africa.dtos.CommentResponse;
import org.semicolon.africa.repository.Comments;
import org.semicolon.africa.repository.Posts;
import org.semicolon.africa.repository.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.semicolon.africa.utils.Mappers.mapCommentRequestToComment;
import static org.semicolon.africa.utils.Mappers.mapCommentRequestToResponse;

@Service
public class CommentServicesImpl implements CommentServices{
    @Autowired
    private Users users;
    @Autowired
    private Posts posts;
    @Autowired
   private Comments comments;
    @Override
    public CommentResponse commentToPost(CommentRequest commentRequest) {
        Comment comment = new Comment();
        User userThatComment  = users.findUserByUserName(commentRequest.getCommenterUserName());
        Post post = posts.findPostByContent(commentRequest.getPostContent());
        User userThatOwnPost = users.findUserByUserName(post.getPosterUserName());
        comment.setCommenter(userThatComment);
        mapCommentRequestToComment(commentRequest,comment);
        comments.save(comment);
        post.setComments(comments.findCommentByContentCommentedOn(comment.getContentCommentedOn()));
        posts.save(post);
        userThatOwnPost.setPosts(posts.findPostByPosterUserName(userThatOwnPost.getUserName()));
        users.save(userThatOwnPost);
        return mapCommentRequestToResponse(commentRequest);
    }

    @Override
    public CommentResponse deleteCommentBy(CommentRequest commentRequest) {
        Post post = posts.findPostByContent(commentRequest.getPostContent());
        if(post == null)throw new PostDoesNotExistException("these post was not created");
        var user = users.findUserByUserName(post.getPosterUserName());
        Comment comment  = comments.findCommentByComment(commentRequest.getComment());
        if(!user.isLoggedIn())throw new UserNotFoundException("you are logged out");
        comments.deleteById(comment.getId());
        post.setComments(comments.findCommentByContentCommentedOn(post.getContent()));
        posts.save(post);
        user.setPosts(posts.findPostByPosterUserName(post.getPosterUserName()));
        users.save(user);
        return mapCommentRequestToResponse(commentRequest);
    }
}
