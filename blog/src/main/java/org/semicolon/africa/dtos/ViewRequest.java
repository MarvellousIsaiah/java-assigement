package org.semicolon.africa.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ViewRequest {
    private String contentToView;
    private String viewerUserName;
    private LocalDateTime timeOfView;
}
