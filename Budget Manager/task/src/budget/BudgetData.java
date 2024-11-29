package budget;

import java.util.Map;

public class BudgetData {

    private double balance;
    private Map<String, Double> foodPurchases;
    private Map<String, Double> clothesPurchases;
    private Map<String, Double> entertainmentPurchases;
    private Map<String, Double> otherPurchases;
    private Map<String, Double> allPurchases;

    // Standard Constructor
    public BudgetData() {}

    // Constructor with parameters
    public BudgetData(double balance,
                      Map<String, Double> foodPurchases,
                      Map<String, Double> clothesPurchases,
                      Map<String, Double> entertainmentPurchases,
                      Map<String, Double> otherPurchases,
                      Map<String, Double> allPurchases) {
        this.balance = balance;
        this.foodPurchases = foodPurchases;
        this.clothesPurchases = clothesPurchases;
        this.entertainmentPurchases = entertainmentPurchases;
        this.otherPurchases = otherPurchases;
        this.allPurchases = allPurchases;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Map<String, Double> getFoodPurchases() {
        return foodPurchases;
    }

    public void setFoodPurchases(Map<String, Double> foodPurchases) {
        this.foodPurchases = foodPurchases;
    }

    public Map<String, Double> getClothesPurchases() {
        return clothesPurchases;
    }

    public void setClothesPurchases(Map<String, Double> clothesPurchases) {
        this.clothesPurchases = clothesPurchases;
    }

    public Map<String, Double> getEntertainmentPurchases() {
        return entertainmentPurchases;
    }

    public void setEntertainmentPurchases(Map<String, Double> entertainmentPurchases) {
        this.entertainmentPurchases = entertainmentPurchases;
    }

    public Map<String, Double> getOtherPurchases() {
        return otherPurchases;
    }

    public void setOtherPurchases(Map<String, Double> otherPurchases) {
        this.otherPurchases = otherPurchases;
    }

    public Map<String, Double> getAllPurchases() {
        return allPurchases;
    }

    public void setAllPurchases(Map<String, Double> allPurchases) {
        this.allPurchases = allPurchases;
    }
}
