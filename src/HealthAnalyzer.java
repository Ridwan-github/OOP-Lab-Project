import java.util.ArrayList;
import java.util.List;

public class HealthAnalyzer {
    private List<String> recommendations;

    public HealthAnalyzer() {
        this.recommendations = new ArrayList<>();
    }

    public void analyzeNutrition(User user) {
        
        double totalCalories = 0;
        double totalProtein = 0;

        for (Meal meal : user.getConsumedMeals()) {
            totalCalories += meal.calculateTotalCalories();
            totalProtein += meal.calculateTotalProtein();
        }

        
        if (totalCalories < user.calculateDailyCalorieNeeds() * 0.8) {
            recommendations.add("Your calorie intake is too low. Consider adding more nutritious foods to your diet.");
        } else if (totalCalories > user.calculateDailyCalorieNeeds() * 1.2) {
            recommendations.add("Your calorie intake is higher than recommended. Consider reducing portion sizes.");
        }

        double recommendedProtein = user.getWeight() * 0.8; 
        if (totalProtein < recommendedProtein) {
            recommendations.add("Your protein intake is below recommendations. Consider adding more protein-rich foods.");
        }
    }

    public void trackGoalProgress(HealthGoal goal) {
        boolean onTrack = goal.checkProgress();
        if (!onTrack) {
            if (goal instanceof WeightGoal) {
                WeightGoal weightGoal = (WeightGoal) goal;
                recommendations.add("You're not on track to reach your weight goal of " +
                        weightGoal.getTargetWeight() + "kg. Consider adjusting your meal plan.");
            } else {
                recommendations.add("You're not on track to reach your health goal. Consider adjusting your approach.");
            }
        }
    }

    public List<String> getRecommendations() {
        return recommendations;
    }
}
