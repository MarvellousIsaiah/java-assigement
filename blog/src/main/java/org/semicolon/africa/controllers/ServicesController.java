package org.semicolon.africa.controllers;
import org.semicolon.africa.Exceptions.UserExceptions;
import org.semicolon.africa.dtos.*;
import org.semicolon.africa.services.CommentServicesImpl;
import org.semicolon.africa.services.PostServicesImpl;
import org.semicolon.africa.services.UserServicesImpl;
import org.semicolon.africa.services.ViewServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/user")
public class ServicesController {

    @Autowired
    private UserServicesImpl userServices;
    @Autowired
    private ViewServicesImpl viewServices;
    @Autowired
    private PostServicesImpl postServices;
    @Autowired
    private CommentServicesImpl commentServices;

     @PostMapping("/signup")
     public ResponseEntity<?> signUp(@RequestBody RegisterRequest registerRequest){
          try {
              return new ResponseEntity<>(new ApiResponses(true, userServices.signUp(registerRequest)),CREATED);
          }catch (UserExceptions e){
                return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
          }
     }


   @PostMapping("/log-in")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userServices.logIn(logInRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }

    @PostMapping("/log-out")
    public ResponseEntity<?> logOut(@RequestBody LogInRequest logInRequest){
        try {
            return new ResponseEntity<>(userServices.logOut(logInRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }

    @PostMapping("/create-post")
    public ResponseEntity<?> createPost(@RequestBody PostRequest postRequest){
         try {
             return new ResponseEntity<>(postServices.createPost(postRequest), CREATED);
         }catch(UserExceptions exceptions){
             return new ResponseEntity<>(exceptions.getMessage(),BAD_REQUEST);
         }
    }


    @GetMapping("/view-user-posts/{username}")
    public ResponseEntity<?> viewUserPost(@PathVariable String username){
          try {
              return new ResponseEntity<>(postServices.getAllPostsOf(username), GONE);
          }catch(UserExceptions e){
              return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
          }
    }

    @PostMapping("/view-a-post")
     public ResponseEntity<?> viewPost(@RequestBody ViewRequest viewRequest){
         try {
             return new ResponseEntity<>(viewServices.viewPosts(viewRequest),CREATED);
         }catch (UserExceptions e){
              return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
         }
    }

    @PostMapping("/delete-a-post")
    public ResponseEntity<?> deletePost(@RequestBody PostRequest postRequest){
        try {
            return new ResponseEntity<>(new ApiResponse("post successfully deleted",postServices.deletePostBy(postRequest)),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }


    @PostMapping("/comment-to-a-post")
    public ResponseEntity<?> commentToPost(@RequestBody CommentRequest commentRequest){
        try {
            return new ResponseEntity<>(commentServices.commentToPost(commentRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }



    @PostMapping("/delete-a-comment")
    public ResponseEntity<?> deleteComment(@RequestBody CommentRequest commentRequest){
        try {
            return new ResponseEntity<>(commentServices.deleteCommentBy(commentRequest),CREATED);
        }catch (UserExceptions e){
            return new ResponseEntity<>(e.getMessage(),BAD_REQUEST);
        }
    }
}
