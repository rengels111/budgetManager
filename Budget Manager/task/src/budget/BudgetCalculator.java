package budget;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Data management and main control
public class BudgetCalculator {
    private double balance = 0;
    private Map<String, Double> purchasesList = new HashMap<>();
    private Map<String, Double> foodList = new HashMap<>();
    private Map<String, Double> clothesList = new HashMap<>();
    private Map<String, Double> entertainmentList = new HashMap<>();
    private Map<String, Double> otherList = new HashMap<>();
    private boolean run = true;
    private final Map<String, ActionStrategy> primaryActions = new HashMap<>();
    private final Map<String, FileOperationStrategy> secondaryActions = new HashMap<>();


    public BudgetCalculator() {
        primaryActions.put("1", new AddIncomeStrategy());
        primaryActions.put("2", new AddPurchasesStrategy());
        primaryActions.put("3", new PrintPurchasesListStrategy());
        primaryActions.put("4", new PrintBalanceStrategy());
        secondaryActions.put("5", new SaveToFileStrategy("purchases.txt"));
        secondaryActions.put("6", new LoadFromFileStrategy("purchases.txt"));
        primaryActions.put("7", new AnalyzeStrategy());
    }


    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            while (run) {
                printMenu();
                String choice = sc.nextLine();

                if ("0".equals(choice)) {
                    run = false;
                    System.out.println("\nBye!");
                    return;
                }

                if (choice.equals("5") || choice.equals("6")) {
                    FileOperationStrategy action = secondaryActions.get(choice);
                    if (action != null) {
                        action.execute(this);  // Execute strategy
                    } else {
                        System.out.println("Invalid choice, try again.");
                    }
                } else {
                    ActionStrategy action = primaryActions.get(choice);
                    if (action != null) {
                        action.execute(this, sc);  // Execute strategy
                    } else {
                        System.out.println("Invalid choice, try again.");
                    }
                }
            }
        }
    }


    private void printMenu() {
        System.out.print("""
                
                Choose your action:
                1) Add income
                2) Add purchase
                3) Show list of purchases
                4) Balance
                5) Save
                6) Load
                7) Analyze (Sort)
                0) Exit
                """);
    }


    // Getter and Setter
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<String, Double> getPurchasesList() {
        return purchasesList;
    }

    public void addToPurchasesList(String name, double price) {
        purchasesList.put(name, price);
    }

    public void setPurchasesList(Map<String, Double> purchasesList) {
        this.purchasesList = purchasesList;
    }

    public Map<String, Double> getFoodList() {
        return foodList;
    }

    public void addToFoodList(String name, double price) {
        foodList.put(name, price);
    }

    public void setFoodList(Map<String, Double> foodList) {
        this.foodList = foodList;
    }

    public Map<String, Double> getClothesList() {
        return clothesList;
    }

    public void addToClothesList(String name, double price) {
        clothesList.put(name, price);
    }

    public void setClothesList(Map<String, Double> clothesList) {
        this.clothesList = clothesList;
    }

    public Map<String, Double> getEntertainmentList() {
        return entertainmentList;
    }

    public void addToEntertainmentList(String name, double price) {
        entertainmentList.put(name, price);
    }

    public void setEntertainmentList(Map<String, Double> entertainmentList) {
        this.entertainmentList = entertainmentList;
    }

    public Map<String, Double> getOtherList() {
        return otherList;
    }

    public void addToOtherList(String name, double price) {
        otherList.put(name, price);
    }

    public void setOtherList(Map<String, Double> otherList) {
        this.otherList = otherList;
    }
}
