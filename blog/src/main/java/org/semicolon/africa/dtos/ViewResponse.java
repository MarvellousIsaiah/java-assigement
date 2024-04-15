package org.semicolon.africa.dtos;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ViewResponse {
    private String contentViewed;
    private String viewerUserName;
    private LocalDateTime timeOfView;
}
