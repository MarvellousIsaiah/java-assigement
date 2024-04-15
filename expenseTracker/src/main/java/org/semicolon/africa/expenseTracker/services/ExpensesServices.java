package org.semicolon.africa.expenseTracker.services;

import dto.ExpensesRequest;
import dto.ExpensesResponse;
import org.semicolon.africa.expenseTracker.models.Expenses;

import java.util.List;

public interface ExpensesServices {
    List<Expenses> getAllExpenses();
    List<Expenses> getAllExpensesWithSame(String description);
    Expenses getExpensesWith(double amount);
    List<Expenses> getExpensesOf(String date);
    Expenses getExpensesByDescription(String description);
    ExpensesResponse addExpenses(ExpensesRequest expensesRequest);
}
