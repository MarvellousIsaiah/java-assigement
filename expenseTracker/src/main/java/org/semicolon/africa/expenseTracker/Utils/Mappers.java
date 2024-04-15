package org.semicolon.africa.expenseTracker.Utils;

import dto.ExpensesRequest;
import dto.ExpensesResponse;
import org.semicolon.africa.expenseTracker.models.Expenses;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Mappers {
    public static void MapRequestToExpenses(ExpensesRequest expensesRequest, Expenses expenses){
        expensesRequest.setDate(LocalDate.now());
        expenses.setDescription(expensesRequest.getDescription());
        expenses.setAmount(BigDecimal.valueOf(expensesRequest.getAmount()));
        expenses.setDate(expensesRequest.getDate());

    }
    public static ExpensesResponse MapRequestToResponse(ExpensesRequest expensesRequest){
                  ExpensesResponse expensesResponse = new ExpensesResponse();
                  expensesResponse.setAmount(expensesRequest.getAmount());
                  expensesResponse.setDescription(expensesRequest.getDescription());
                  expensesResponse.setDate(expensesRequest.getDate());
                  return expensesResponse;
    }
}
