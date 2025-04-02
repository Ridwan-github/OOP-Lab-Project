import java.util.HashMap;
import java.util.Map;

public class NutritionReport {
    private User user;
    private Map<String, Double> nutritionStats;
    public NutritionReport(User user) {
        this.user = user;
        this.nutritionStats = new HashMap<>();
    }

    public void generateDailyStatistics() {
        double totalCalories = 0;

        for (Meal meal : user.getConsumedMeals()) {
            totalCalories += meal.calculateTotalCalories();
        }

        nutritionStats.put("calories", totalCalories);
        nutritionStats.put("calorieNeeds", user.calculateDailyCalorieNeeds());
        nutritionStats.put("calorieDeficit", user.calculateDailyCalorieNeeds() - totalCalories);
    }

    public void display() {
        System.out.println("=== Nutrition Report for " + user.getName() + " ===");
        System.out.println("Daily Calorie Needs: " + nutritionStats.get("calorieNeeds"));
        System.out.println("Consumed Calories: " + nutritionStats.get("calories"));
        System.out.println("Calorie Deficit/Surplus: " + nutritionStats.get("calorieDeficit"));

    }
}
