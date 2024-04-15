package org.semicolon.africa.services;


import org.semicolon.africa.dtos.CommentRequest;
import org.semicolon.africa.dtos.CommentResponse;

public interface CommentServices {
    CommentResponse commentToPost(CommentRequest commentRequest);
    CommentResponse deleteCommentBy(CommentRequest commentRequest);
}
