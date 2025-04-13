import java.util.HashMap;
import java.util.Map;

class Meal {
    private String name;
    private Map<Food, Double> foodItems; // Food and its quantity

    public Meal(String name) {
        this.name = name;
        this.foodItems = new HashMap<>();
    }

    public void addFoodItem(Food food, double quantity) {
        foodItems.put(food, quantity);
    }

    public double calculateTotalCalories() {
        double total = 0;
        for (Map.Entry<Food, Double> entry : foodItems.entrySet()) {
            total += entry.getKey().getCalories() * entry.getValue();
        }
        return total;
    }

    public double calculateTotalProtein() {
        double total = 0;
        for (Map.Entry<Food, Double> entry : foodItems.entrySet()) {
            total += entry.getKey().getProtein() * entry.getValue();
        }
        return total;
    }

    public double calculateTotalCarbs() {
        double total = 0;
        for (Map.Entry<Food, Double> entry : foodItems.entrySet()) {
            total += entry.getKey().getCarbs() * entry.getValue();
        }
        return total;
    }

    public double calculateTotalFats() {
        double total = 0;
        for (Map.Entry<Food, Double> entry : foodItems.entrySet()) {
            total += entry.getKey().getFats() * entry.getValue();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public Map<Food, Double> getFoodItems() {
        return foodItems;
    }
}