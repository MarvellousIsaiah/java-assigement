package org.semicolon.africa.dtos;
import lombok.Data;
@Data
public class CommentResponse {
    private String commenterUserName;
    private String comment;
    private String postContent;
}
