package org.semicolon.africa.repository;


import org.semicolon.africa.data.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Comments extends MongoRepository<Comment,String> {
    List<Comment> findCommentByContentCommentedOn(String contentCommentedOn);
    Comment findCommentByComment(String comment);
}
