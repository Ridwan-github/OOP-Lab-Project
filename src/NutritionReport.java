import java.util.HashMap;
import java.util.Map;

class NutritionReport {
    private User user;
    private Map<String, Double> nutritionStats;

    public NutritionReport(User user) {
        this.user = user;
        this.nutritionStats = new HashMap<>();
    }

    public void generateDailyStatistics() {
        double totalCalories = 0;
        double totalProtein = 0;
        double totalCarbs = 0;
        double totalFats = 0;

        for (Meal meal : user.getConsumedMeals()) {
            totalCalories += meal.calculateTotalCalories();
            totalProtein += meal.calculateTotalProtein();
            totalCarbs += meal.calculateTotalCarbs();
            totalFats += meal.calculateTotalFats();
        }

        nutritionStats.put("calories", totalCalories);
        nutritionStats.put("protein", totalProtein);
        nutritionStats.put("carbs", totalCarbs);
        nutritionStats.put("fats", totalFats);
        nutritionStats.put("calorieNeeds", user.calculateDailyCalorieNeeds());
        nutritionStats.put("calorieDeficit", user.calculateDailyCalorieNeeds() - totalCalories);
    }

    public void display() {
        System.out.println("=== Nutrition Report for " + user.getName() + " ===");
        System.out.println("Daily Calorie Needs: " + String.format("%.2f", nutritionStats.get("calorieNeeds")));
        System.out.println("Consumed Calories: " + String.format("%.2f", nutritionStats.get("calories")));
        System.out.println("Calorie Deficit/Surplus: " + String.format("%.2f", nutritionStats.get("calorieDeficit")));
        System.out.println("Protein: " + String.format("%.2f", nutritionStats.get("protein")) + "g");
        System.out.println("Carbs: " + String.format("%.2f", nutritionStats.get("carbs")) + "g");
        System.out.println("Fats: " + String.format("%.2f", nutritionStats.get("fats")) + "g");
    }
}