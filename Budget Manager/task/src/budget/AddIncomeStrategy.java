package budget;

import java.util.Scanner;

public class AddIncomeStrategy implements ActionStrategy {
    @Override
    public void execute(BudgetCalculator calculator, Scanner sc) {
        System.out.println("\nEnter income:");
        double income = sc.nextDouble();
        calculator.setBalance(calculator.getBalance() + income);

        System.out.println("Income was added!");
        sc.nextLine();  // Use up the remaining line
    }
}
