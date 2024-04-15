package org.semicolon.africa.expenseTracker.repository;
import org.semicolon.africa.expenseTracker.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses,Long> {
    List<Expenses> findExpensesByDate(LocalDate date);
    Expenses findExpensesByAmount(BigDecimal amount);
    Expenses findExpensesByDescription(String description);
}

