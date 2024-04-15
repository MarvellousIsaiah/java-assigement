package org.semicolon.africa.expenseTracker.services;
import dto.ExpensesRequest;
import dto.ExpensesResponse;
import org.semicolon.africa.expenseTracker.models.Expenses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.semicolon.africa.expenseTracker.repository.ExpensesRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import static org.semicolon.africa.expenseTracker.Utils.Mappers.MapRequestToExpenses;
import static org.semicolon.africa.expenseTracker.Utils.Mappers.MapRequestToResponse;

@Service
public class ExpensesServicesImpl implements ExpensesServices{
    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Expenses> getAllExpenses() {
        return expensesRepository.findAll();
    }

    @Override
    public List<Expenses> getAllExpensesWithSame(String description) {
                  return expensesRepository.findAll().stream().
                    filter(expenses -> expenses.getDescription().
                    equalsIgnoreCase(description)).collect(Collectors.toList());
    }

    @Override
    public Expenses getExpensesWith(double amount) {
        return expensesRepository.findExpensesByAmount(BigDecimal.valueOf(amount));
    }

    @Override
    public List<Expenses> getExpensesOf(String date) {
        LocalDate expensesDate = LocalDate.parse(date);
        return expensesRepository.findExpensesByDate(expensesDate);
    }

    @Override
    public Expenses getExpensesByDescription(String description) {
        return expensesRepository.findExpensesByDescription(description);
    }

    @Override
    public ExpensesResponse addExpenses(ExpensesRequest expensesRequest) {
            Expenses expenses = new Expenses();
            MapRequestToExpenses(expensesRequest,expenses);
            expensesRepository.save(expenses);
           return MapRequestToResponse(expensesRequest);
    }
}
