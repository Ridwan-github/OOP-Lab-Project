public class Main {
public static void main(String[] args) {
        NutritionSystem system = new NutritionSystem();


        User user = new User("John", 75.0, 180.0, 30, Gender.MALE, ActivityLevel.MODERATE);
        system.addUser(user);

        // Add some food items to the database
        system.getFoodList().addFood(new Food("Apple", 52, 0.3, 14.0, 0.2));
        system.getFoodList().addFood(new Food("Chicken Breast", 165, 31.0, 0.0, 3.6));
        system.getFoodList().addFood(new Food("Brown Rice", 112, 2.6, 23.0, 0.9));
        system.getFoodList().addFood(new Food("Spinach", 23, 2.9, 3.6, 0.4));

        // Create a meal plan
        MealPlan weeklyPlan = new MealPlan("Balanced Week", 7);

        // Add meals to the plan
        Meal breakfast = new Meal("Balanced Breakfast");
        breakfast.addFoodItem(system.getFoodList().getFood("Apple"), 1.0);
        breakfast.addFoodItem(system.getFoodList().getFood("Brown Rice"), 0.5);

        Meal lunch = new Meal("Protein Lunch");
        lunch.addFoodItem(system.getFoodList().getFood("Chicken Breast"), 1.0);
        lunch.addFoodItem(system.getFoodList().getFood("Spinach"), 2.0);

        weeklyPlan.addMeal(breakfast);
        weeklyPlan.addMeal(lunch);

        // Assign the meal plan to the user
        user.setCurrentMealPlan(weeklyPlan);

        // Record that the user consumed these meals
        user.recordMealConsumption(breakfast);

        // Generate nutrition reports
        NutritionReport dailyReport = system.generateDailyReport(user);
        dailyReport.display();

        // Create and track a health goal
        HealthGoal weightGoal = new WeightGoal(user, 70.0, 30);
        system.addHealthGoal(user, weightGoal);

        // Check progress and recommendations
        HealthAnalyzer analyzer = new HealthAnalyzer();
        analyzer.analyzeNutrition(user);
        analyzer.trackGoalProgress(weightGoal);

        // Display recommendations
        for (String recommendation : analyzer.getRecommendations()) {
                System.out.println("Recommendation: " + recommendation);
        }
}
}