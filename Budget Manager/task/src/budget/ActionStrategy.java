package budget;

import java.util.Scanner;

public interface ActionStrategy {
    void execute(BudgetCalculator calculator, Scanner sc);
}
