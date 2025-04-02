import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NutritionReport {
    private User user;
    private Map<String, Double> nutritionStats;
    private List<String> recommendations;

    public NutritionReport(User user) {
        this.user = user;
        this.nutritionStats = new HashMap<>();
        this.recommendations = new ArrayList<>();
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
    public void analyzeNutrition(User user) {
        double totalCalories = 0;
        for (Meal meal : user.getConsumedMeals()) {
            totalCalories += meal.calculateTotalCalories();
        }

        if (totalCalories < user.calculateDailyCalorieNeeds() * 0.8) {
            recommendations.add("Your calorie intake is too low. Consider adding more nutritious foods to your diet.");
        } else if (totalCalories > user.calculateDailyCalorieNeeds() * 1.2) {
            recommendations.add("Your calorie intake is higher than recommended. Consider reducing portion sizes.");
        }
    }

    public void display() {
        System.out.println("=== Nutrition Report for " + user.getName() + " ===");
        System.out.println("Daily Calorie Needs: " + nutritionStats.get("calorieNeeds"));
        System.out.println("Consumed Calories: " + nutritionStats.get("calories"));
        System.out.println("Calorie Deficit/Surplus: " + nutritionStats.get("calorieDeficit"));
        System.out.println("Recommendations:");
        for (String recommendation : recommendations) {
            System.out.println("- " + recommendation);
        }

    }
}
