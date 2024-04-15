package org.semicolon.africa.repository;

import org.junit.jupiter.api.Test;
import org.semicolon.africa.data.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
 public class PostsTest {

    @Autowired
    private Posts posts;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
  public  void testPost(){
      assertNotNull(mongoTemplate.getDb());
  }

  @Test
    public  void testThatPostCanSave(){
        Post post = new Post();
        post.setContent("okay");
        post.setTimeCreated(LocalDateTime.now());
        posts.save(post);
        var mypost = mongoTemplate.findById(post.getId(),Post.class);
        assertEquals(mypost.getContent(),post.getContent());
  }


}