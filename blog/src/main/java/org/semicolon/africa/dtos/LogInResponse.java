package org.semicolon.africa.dtos;

import lombok.Data;
import org.semicolon.africa.data.models.Post;

import java.util.List;

@Data
public class LogInResponse {
        private String userName;
        private List<Post> posts;
}
