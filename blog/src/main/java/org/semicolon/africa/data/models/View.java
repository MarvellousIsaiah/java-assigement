package org.semicolon.africa.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document("blog-view")
public class View {
 @Id
 private String id;
 private String viewerUserName;
 private String contentToView;
 private LocalDateTime timeOfView;
}
