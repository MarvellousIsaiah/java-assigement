package org.semicolon.africa.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Document("Blog-post")
public class Post {
    @Id
    private  String id;
    private String title;
    private String content;
    private String posterUserName;
    @DBRef
    private List<Comment> comments = new ArrayList<>();
    @DBRef
    private List<View> views=new ArrayList<>();
    private LocalDateTime timeCreated;
}
