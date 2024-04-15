package org.semicolon.africa.expenseTracker.controllers;
import dto.ExpensesRequest;
import org.semicolon.africa.expenseTracker.services.ExpensesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/expense-tracker")
public class ExpensesController {
    @Autowired
     private ExpensesServicesImpl expensesServices;

    @PostMapping("/add-expenses")
    public ResponseEntity<?> addExpenses(@RequestBody ExpensesRequest expensesRequest){
             try{
                 return new ResponseEntity<>(expensesServices.addExpenses(expensesRequest), CREATED);
             }catch (RuntimeException exception){
                  return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
             }
    }
    @GetMapping("/get-expense-by-description/{description}")
    public ResponseEntity<?> getExpenseByDescription(@PathVariable("description") String description){
        try{
            return new ResponseEntity<>(expensesServices.getExpensesByDescription(description), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }
    @GetMapping("/get-expenses-by-description/{description}")
    public ResponseEntity<?> getExpensesByDescription(@PathVariable("description") String description){
        try{
            return new ResponseEntity<>(expensesServices.getAllExpensesWithSame(description), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }
    @GetMapping("/get-expenses-by-date/{date}")
    public ResponseEntity<?> getExpensesByDate(@PathVariable("date") String date){
        try{
            return new ResponseEntity<>(expensesServices.getExpensesOf(date), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }
    @GetMapping("/get-expenses-by-amount/{amount}")
    public ResponseEntity<?> getExpensesByAmount(@PathVariable("amount") double amount){
        try{
            return new ResponseEntity<>(expensesServices.getExpensesWith(amount), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }
    @GetMapping("/get-all-expenses")
    public ResponseEntity<?> getExpenses(){
        try{
            return new ResponseEntity<>(expensesServices.getAllExpenses(), CREATED);
        }catch (RuntimeException exception){
            return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
        }
    }

}
