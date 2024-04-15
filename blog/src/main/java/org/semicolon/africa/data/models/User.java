package org.semicolon.africa.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@Document("blog-user")
public class User {
    @Id
    private String id;
    private String userName;
    private String password;
    @DBRef
    private List<Post> posts = new ArrayList<Post>();
    private String firstName;
    private String lastName;
    private boolean isLoggedIn;
}
