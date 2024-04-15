package org.semicolon.africa.repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.semicolon.africa.data.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
 public class UsersTest {

 @Autowired
 private Users users;
@Autowired
 private MongoTemplate mongoTemplate;

 @Test
 public void testDb(){
 assertNotNull(mongoTemplate.getDb());
 }

@Test
 public  void  testAgain(){
   users.deleteAll();
   User user = new User();
   user.setUserName("semicolon");
   user.setPassword("hard");
   users.save(user);
   User user1 = mongoTemplate.findById(user.getId(), User.class);
   assertEquals(user1.getUserName(),user.getUserName());
   users.save(user1);
}




}