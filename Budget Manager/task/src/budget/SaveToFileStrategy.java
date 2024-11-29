package budget;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFileStrategy implements FileOperationStrategy {
    private final String fileName;

    public SaveToFileStrategy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(BudgetCalculator calculator) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(fileName)) {
            BudgetData data = new BudgetData(calculator.getBalance(), calculator.getFoodList(), calculator.getClothesList(), calculator.getEntertainmentList(), calculator.getOtherList(), calculator.getPurchasesList());
            gson.toJson(data, writer);
            System.out.println("\nPurchases were saved!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        }
    }
}
