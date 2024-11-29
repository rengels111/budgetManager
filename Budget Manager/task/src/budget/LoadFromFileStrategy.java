package budget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;

public class LoadFromFileStrategy implements FileOperationStrategy {
    private final String fileName;

    public LoadFromFileStrategy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute(BudgetCalculator calculator) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(fileName)) {
            Type type = new TypeToken<BudgetData>() {}.getType();
            BudgetData data = gson.fromJson(reader, type);
            calculator.setBalance(data.getBalance());
            calculator.setFoodList(data.getFoodPurchases());
            calculator.setClothesList(data.getClothesPurchases());
            calculator.setEntertainmentList(data.getEntertainmentPurchases());
            calculator.setOtherList(data.getOtherPurchases());
            calculator.setPurchasesList(data.getAllPurchases());
            System.out.println("\nPurchases were loaded!");
        } catch (IOException e) {
            System.out.println("An error occurred while loading data: " + e.getMessage());
        }
    }
}
