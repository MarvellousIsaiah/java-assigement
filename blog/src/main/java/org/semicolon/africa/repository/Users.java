package org.semicolon.africa.repository;



import org.semicolon.africa.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;

public interface Users extends MongoRepository<User,String> {
    User findUserByUserName(String userName);
}
