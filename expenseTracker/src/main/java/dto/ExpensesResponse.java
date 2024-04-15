package dto;
import lombok.Data;
import java.time.LocalDate;
@Data
public class ExpensesResponse{
    private String description;
    private double amount;
    private LocalDate date;
}
