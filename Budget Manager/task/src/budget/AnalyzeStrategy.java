package budget;

import java.util.*;

public class AnalyzeStrategy implements ActionStrategy {

    final static String FOOD = "Food:";
    final static String CLOTHES = "Clothes";
    final static String ENTERTAINMENT = "Entertainment";
    final static String OTHER = "Other:";
    final static String ALL = "All:";

    @Override
    public void execute(BudgetCalculator calculator, Scanner sc) {
        while (true) {
            printSortMenu();

            String choice = sc.nextLine();

            if (choice.equals("4")) {
                return;
            } else {
                switch (choice) {
                    case "1" -> sortAndPrintList(calculator.getPurchasesList(), ALL);
                    case "2" -> sortByType(calculator.getFoodList(),
                            calculator.getClothesList(),
                            calculator.getEntertainmentList(),
                            calculator.getOtherList());
                    case "3" -> sortCertainType(calculator, sc);
                }
            }
        }
    }

    private void sortAndPrintList(Map<String, Double> purchasesList, String name) {

        if (purchasesList.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            // Sort
            List<Map.Entry<String, Double>> sortedPurchases = bubbleSort(purchasesList);

            // calculate Total
            double total = calculateExpensesOfList(purchasesList);

            // Output the list
            System.out.println(name);
            for (Map.Entry<String, Double> entry : sortedPurchases) {
                System.out.printf("%s $%.2f%n", entry.getKey(), entry.getValue());
            }
            System.out.printf("Total: $%.2f%n", total);
        }

    }

    private void sortByType(Map<String, Double> foodList,
                            Map<String, Double> clothesList,
                            Map<String, Double> entertainmentList,
                            Map<String, Double> otherList) {
        double foodExpenses = calculateExpensesOfList(foodList);
        double clothesExpenses = calculateExpensesOfList(clothesList);
        double entertainmentExpenses = calculateExpensesOfList(entertainmentList);
        double otherExpenses = calculateExpensesOfList(otherList);

        Map<String, Double> listOfTypes = new HashMap<>();
        listOfTypes.put("Food", foodExpenses);
        listOfTypes.put("Clothes", clothesExpenses);
        listOfTypes.put("Entertainment", entertainmentExpenses);
        listOfTypes.put("Other", otherExpenses);

        // Sort
        List<Map.Entry<String, Double>> listOfSortedTypes = bubbleSort(listOfTypes);

        // calculate Total
        double total = calculateExpensesOfList(listOfTypes);

        // Output the list
        System.out.println("Types:");
        for (Map.Entry<String, Double> entry : listOfSortedTypes) {
            System.out.printf("%s - $%.2f%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("Total sum: $%.2f%n", total);
    }

    private void sortCertainType(BudgetCalculator calculator, Scanner sc) {
        printTypeMenu();

        String choice = sc.nextLine();

        switch (choice) {
            case "1" -> sortAndPrintList(calculator.getFoodList(), FOOD);
            case "2" -> sortAndPrintList(calculator.getClothesList(), CLOTHES);
            case "3" -> sortAndPrintList(calculator.getEntertainmentList(), ENTERTAINMENT);
            case "4" -> sortAndPrintList(calculator.getOtherList(), OTHER);
        }
    }

    private Double calculateExpensesOfList(Map<String, Double> purchasesList) {
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(purchasesList.entrySet());

        double sum = 0;

        for (Map.Entry<String, Double> entry : entryList) {
            sum += entry.getValue();
        }

        return sum;
    }

    private List<Map.Entry<String, Double>> bubbleSort(Map<String, Double> purchasesList) {
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(purchasesList.entrySet());

        int size = entryList.size();
        boolean swapped;

        // Bubble sort
        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size -1; j++) {
                // Compare the prices
                if (entryList.get(j).getValue() < entryList.get(j + 1).getValue()) {
                    // swap entries
                    Collections.swap(entryList, j, j + 1);
                    swapped = true;
                }
            }
            // if no more elements were swapped, then the list is sorted
            if (!swapped) break;
        }
        return entryList;
    }

    private void printSortMenu() {
        System.out.println("""
                
                How do you want to sort?
                1) Sort all purchases
                2) Sort by type
                3) Sort certain type
                4) Back
                """);
    }

    private void printTypeMenu() {
        System.out.println("""
                
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                """);
    }
}
