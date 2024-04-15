package africa.semicolon.ToDoList.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("todo User")
public class User {
    private String id;
    private String userName;
    private boolean isActive;
    private String password;
    private List<Task> UserTask = new ArrayList<>();


}
