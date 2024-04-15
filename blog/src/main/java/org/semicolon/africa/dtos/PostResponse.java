package org.semicolon.africa.dtos;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponse {
    private LocalDateTime timeCreated;
    private String title;
    private String content;
    private String posterUserName;
}
