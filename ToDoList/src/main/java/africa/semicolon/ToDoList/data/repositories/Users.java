package africa.semicolon.ToDoList.data.repositories;


import africa.semicolon.ToDoList.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  Users extends MongoRepository<User,String>{
    User  findUserByUserName(String authorName);

}
