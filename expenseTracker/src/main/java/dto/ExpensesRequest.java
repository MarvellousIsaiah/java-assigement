package dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class ExpensesRequest {
    private String description;
    private double amount;
    private LocalDate date;
}
