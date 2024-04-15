package org.semicolon.africa.expenseTracker.services;

import dto.ExpensesRequest;
import org.junit.jupiter.api.Test;
import org.semicolon.africa.expenseTracker.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpensesServicesImplTest {
   @Autowired
   private ExpensesServicesImpl expensesServices;
   @Autowired
   private ExpensesRepository expensesRepository;

    @Test
    public void testThatWeCanGetAllExpenses() {
        expensesRepository.deleteAll();
        ExpensesRequest expensesRequest = new ExpensesRequest();
        expensesRequest.setAmount(2300000.05);
        expensesRequest.setDescription("food money");
        expensesServices.addExpenses(expensesRequest);
        assertEquals(expensesServices.getAllExpenses().size(),1);
    }

    @Test
    public void testThatWeCanGetAllExpensesWithSameDate() {
        expensesRepository.deleteAll();
        ExpensesRequest expensesRequest = new ExpensesRequest();
        expensesRequest.setAmount(2300000.05);
        expensesRequest.setDescription("food money");
        expensesServices.addExpenses(expensesRequest);
        ExpensesRequest expensesRequest1 = new ExpensesRequest();
        expensesRequest1.setAmount(2300.80);
        expensesRequest1.setDescription("food money for afternoon");
        expensesServices.addExpenses(expensesRequest1);
        assertEquals(expensesServices.getAllExpenses().size(),2);
        assertEquals(expensesServices.getExpensesOf("07/04/2024").size(),2);
    }

    @Test
   public void testThatWeCanGetAllExpensesWithSameDescription() {
        expensesRepository.deleteAll();
        ExpensesRequest expensesRequest = new ExpensesRequest();
        expensesRequest.setAmount(2300000.05);
        expensesRequest.setDescription("food money");
        expensesServices.addExpenses(expensesRequest);
        ExpensesRequest expensesRequest1 = new ExpensesRequest();
        expensesRequest1.setAmount(2300.80);
        expensesRequest1.setDescription("food money");
        expensesServices.addExpenses(expensesRequest1);
        assertEquals(expensesServices.getAllExpensesWithSame("food money").size(),2 );

    }

    @Test
    public void testThatWeCanGetExpenses() {
        expensesRepository.deleteAll();
        ExpensesRequest expensesRequest = new ExpensesRequest();
        expensesRequest.setAmount(2300000.05);
        expensesRequest.setDescription("food money");
        expensesServices.addExpenses(expensesRequest);
        assertEquals(expensesServices.getExpensesWith(2300000.05).getAmount(),BigDecimal.valueOf(2300000.05));

    }

    @Test
   public void testGetExpensesByDescription() {
        expensesRepository.deleteAll();
        ExpensesRequest expensesRequest = new ExpensesRequest();
        expensesRequest.setAmount(2300000.05);
        expensesRequest.setDescription("food money");
        expensesServices.addExpenses(expensesRequest);
      assertEquals(expensesServices.getExpensesByDescription("food money").getAmount(),BigDecimal.valueOf(2300000.05));
    }
}