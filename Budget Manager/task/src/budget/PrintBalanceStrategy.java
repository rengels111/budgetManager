package budget;

import java.util.Scanner;

public class PrintBalanceStrategy implements ActionStrategy {
    @Override
    public void execute(BudgetCalculator calculator, Scanner sc) {
        System.out.printf("\nBalance: $%.2f%n", calculator.getBalance());
    }
}
