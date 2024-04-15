package org.semicolon.africa.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("blog-comment")
public class Comment {
    @Id
    private String id;
    private  User commenter;
    private String comment;
    private String contentCommentedOn;
}
