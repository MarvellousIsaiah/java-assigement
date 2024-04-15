package org.semicolon.africa.repository;


import org.semicolon.africa.data.models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Posts extends MongoRepository<Post,String> {
      Post findPostByContent(String content);
      List<Post> findPostByTitle(String title);
      List<Post> findPostByPosterUserName(String username);
      void deletePostById(String id);
}
