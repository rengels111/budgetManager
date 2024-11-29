package budget;

import java.util.HashMap;
import java.util.Scanner;

public class AddPurchasesStrategy implements ActionStrategy {
    @Override
    public void execute(BudgetCalculator calculator, Scanner sc) {
        while (true) {
            printTypeMenu();

            String choice = sc.nextLine();

            if (choice.equals("5")) {
                return;
            } else {
                System.out.println("\nEnter purchase name:");
                String name = sc.nextLine();

                System.out.println("Enter its price:");
                double price = sc.nextDouble();

                calculator.addToPurchasesList(name, price);  // add purchase
                calculator.setBalance(calculator.getBalance() - price);  // adjust balance
                if (calculator.getBalance() < 0) calculator.setBalance(0);  // minimum balance is 0

                // add purchase to respective list
                switch (choice) {
                    case "1" -> calculator.addToFoodList(name, price);
                    case "2" -> calculator.addToClothesList(name, price);
                    case "3" -> calculator.addToEntertainmentList(name, price);
                    case "4" -> calculator.addToOtherList(name, price);
                    default -> System.out.println("Incorrect choice");
                }

                System.out.println("Purchase was added!");
                sc.nextLine();  // Use up the remaining line
            }
        }

    }

    private void printTypeMenu() {
        System.out.println("""
                
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                5) Back
                """);
    }
}
