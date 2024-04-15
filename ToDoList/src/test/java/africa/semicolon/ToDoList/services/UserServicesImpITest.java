package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.*;
import africa.semicolon.ToDoList.data.repositories.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesImpITest {
   @Autowired
    private UserServicesImpI userService;
   @Autowired
   private Users userRepo;


   @Test
   public void TestForSignUp(){
       userRepo.deleteAll();
        SignUpRequest signUpRequest = new SignUpRequest();
        signUpRequest.setUserName("semicolon ");
        signUpRequest.setPassword("hard");
        userService.signUp(signUpRequest);
        assertEquals(1,userRepo.count());

   }
   @Test
    public void TestSignup(){
       userRepo.deleteAll();
       SignUpRequest signUpRequest = new SignUpRequest();
       signUpRequest.setPassword("semicolon");
       signUpRequest.setUserName("hard");
       userService.signUp(signUpRequest);


       SignUpRequest signUpRequest1 = new SignUpRequest();
       signUpRequest1.setPassword("semicolon");
       signUpRequest1.setUserName("hard");
       userService.signUp(signUpRequest1);
       assertEquals(2, userRepo.count());


   }
   @Test
    public void TestForLoggin(){
       userRepo.deleteAll();
       SignUpRequest signUpRequest = new SignUpRequest();
       signUpRequest.setPassword("semicolon");
       signUpRequest.setUserName("hard");
       userService.signUp((signUpRequest));

       LogginRequest logginRequest = new LogginRequest();
       logginRequest.setPassword("semicolon");
       logginRequest.setUserName("hard");
       userService.LogIn(logginRequest);
       assertEquals(1,userRepo.count());
   }

   @Test
    public void TestForTwoLogin(){
       userRepo.deleteAll();
       SignUpRequest signUpRequest = new SignUpRequest();
       signUpRequest.setUserName("hard");
       signUpRequest.setPassword("semicolon");
       userService.signUp(signUpRequest);

       LogginRequest logginRequest = new LogginRequest();
       logginRequest.setPassword("semicolon");
       logginRequest.setUserName("hard");
       userService.LogIn(logginRequest);

       SignUpRequest signUpRequest1 = new SignUpRequest();
       signUpRequest1.setPassword("semicolon1");
       signUpRequest1.setUserName("hard1");
       userService.signUp(signUpRequest1);

       LogginRequest logginRequest1 = new LogginRequest();
       logginRequest1.setUserName("hard1");
       logginRequest1.setPassword("semicolon1");
       userService.LogIn(logginRequest1);
       assertEquals(2, userRepo.count());

   }
   @Test
    public void TestForSignUp_login_logout(){
       userRepo.deleteAll();
       SignUpRequest signUpRequest = new SignUpRequest();
       signUpRequest.setUserName("semicolon");
       signUpRequest.setPassword("hard");
       userService.signUp(signUpRequest);

       LogginRequest logginRequest = new LogginRequest();
       logginRequest.setPassword("hard");
       logginRequest.setUserName("semicolon");
       userService.LogIn(logginRequest);

       LoggoutRequest loggoutRequest = new LoggoutRequest();
       loggoutRequest.setUserName("semicolon");
       assertEquals("semicolon", userService.findByUser("semicolon").getUserName());




   }


}