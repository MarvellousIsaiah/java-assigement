package org.semicolon.africa.services;



import org.semicolon.africa.data.models.Post;
import org.semicolon.africa.dtos.PostRequest;
import org.semicolon.africa.dtos.PostResponse;

import java.util.List;

public interface PostServices {
    PostResponse createPost(PostRequest postRequest);
    List<Post> getAllPostsOf(String userName);
    PostResponse deletePostBy(PostRequest postRequest);

}
