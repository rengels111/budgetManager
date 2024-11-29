package budget;

import java.util.Map;
import java.util.Scanner;

public class PrintPurchasesListStrategy implements ActionStrategy {
    @Override
    public void execute(BudgetCalculator calculator, Scanner sc) {
        while (true) {
            printTypeMenu();

            String choice = sc.nextLine();

            if (choice.equals("6")) {
                return;
            } else {
                switch (choice) {
                    case "1" -> showRequestedList(calculator.getFoodList());
                    case "2" -> showRequestedList(calculator.getClothesList());
                    case "3" -> showRequestedList(calculator.getEntertainmentList());
                    case "4" -> showRequestedList(calculator.getOtherList());
                    case "5" -> showRequestedList(calculator.getPurchasesList());
                }
            }
        }
    }

    private void printTypeMenu() {
        System.out.println("""
                
                Choose the type of purchases
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) All
                6) Back
                """);
    }

    private void showRequestedList(Map<String, Double> list) {
        System.out.println();
        if (list.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            list.forEach((name, price) -> System.out.printf("%s $%.2f%n", name, price));

            double total = list.values().stream().mapToDouble(Double::doubleValue).sum();
            System.out.printf("Total sum: $%.2f%n", total);
        }

    }
}
