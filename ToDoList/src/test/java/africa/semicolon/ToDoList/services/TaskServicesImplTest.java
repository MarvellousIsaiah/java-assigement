package africa.semicolon.ToDoList.services;

import africa.semicolon.ToDoList.DTO.TaskRequest;
import africa.semicolon.ToDoList.data.model.User;
import africa.semicolon.ToDoList.data.repositories.Tasks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static africa.semicolon.ToDoList.data.model.TaskPriority.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TaskServicesImplTest{
    @Autowired
    private TaskServicesImpl taskServices;
  @Autowired
     private Tasks tasks;
  @BeforeEach
  private void setUp(){
      tasks.deleteAll();
  }
  @Test
    public void TestFindByTitle(){

//        User user = new User();
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTask("semicolon");
        taskRequest.setTaskAuthor("hard");
       taskServices.createTask(taskRequest);
       assertEquals(tasks.count(),1);
       var task = taskServices.findTasksByTitle(taskRequest.getTask());
       assertEquals(task.getTitle(),taskRequest.getTask());
    }
    @Test
    public void TestCreateTask(){
//      User user = new User();
      TaskRequest taskRequest = new TaskRequest();
      taskRequest.setTaskAuthor("semicolon");
      taskRequest.setTask("hard");
      taskServices.createTask(taskRequest);
      assertEquals(tasks.count(),1);

    }
    @Test
    public void TestDeleteTask(){
        TaskRequest taskRequest = new TaskRequest();
        taskRequest.setTaskAuthor("semicolon");
        taskRequest.setTask("hard");
        taskRequest.setPriority(IMPORTANT);
        taskServices.createTask(taskRequest);
        taskServices.deleteTask(taskRequest);
        assertEquals(tasks.count(),0);

    }
    @Test
    public void TestListOfTask(){
      User user = new User();
      TaskRequest taskRequest = new TaskRequest();
      taskRequest.setTask("semicolon");
      taskRequest.setTaskAuthor("hard");
      TaskRequest taskRequest1 = new TaskRequest();
      taskRequest1.setTaskAuthor("semicolon");
      taskRequest1.setTask("hard");
      taskServices.createTask(taskRequest);
      taskServices.createTask(taskRequest1);
      assertEquals(tasks.count(),2);
  }
  @Test
  public void TestForUpdate(){
      TaskRequest taskRequest = new TaskRequest();
      taskRequest.setTaskAuthor("semicolon");
      taskRequest.setTask("hard");
      taskRequest.setPriority(IMPORTANT);
      taskServices.createTask(taskRequest);
      TaskRequest taskRequest2 = new TaskRequest();
      taskRequest2.setTaskAuthor("semicolon");
      taskRequest2.setTask("is hard");
      taskRequest2.setPriority(LESS_IMPORTANT);
      taskServices.createTask(taskRequest2);
      TaskRequest taskRequest3 = new TaskRequest();
      taskRequest3.setTaskAuthor("semicolon");
      taskRequest3.setTask("is hard");
      taskRequest3.setPriority(MOST_IMPORTANT);
      taskRequest3.setNewTask("is very very hard");
      taskServices.updateTask(taskRequest3);
      assertEquals(tasks.count(),2);
  }
 @Test
  public void testThatWeCanFindAllCompletedTask(){
      TaskRequest taskRequest = new TaskRequest();
      taskRequest.setTaskAuthor("semicolon");
      taskRequest.setTask("hard");
      taskRequest.setPriority(IMPORTANT);
      taskServices.createTask(taskRequest);
      taskServices.completeTask(taskRequest);
      TaskRequest taskRequest2 = new TaskRequest();
      taskRequest2.setTaskAuthor("semicolon");
      taskRequest2.setTask("is hard");
      taskRequest2.setPriority(LESS_IMPORTANT);
      taskServices.createTask(taskRequest2);
      taskServices.completeTask(taskRequest2);
      TaskRequest taskRequest3 = new TaskRequest();
      taskRequest3.setTaskAuthor("semicolon");
      taskRequest3.setTask("is hard");
      taskRequest3.setPriority(MOST_IMPORTANT);
      taskRequest3.setNewTask("is very very hard");
      taskServices.updateTask(taskRequest3);
      assertEquals(tasks.count(),2);
      assertEquals(1,taskServices.findAllUserCompletedTasks("semicolon").size());
  }


}