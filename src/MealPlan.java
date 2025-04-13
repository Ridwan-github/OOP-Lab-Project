import java.util.ArrayList;
import java.util.List;

class MealPlan {
    private String name;
    private int durationInDays;
    private List<Meal> meals;

    public MealPlan(String name, int durationInDays) {
        this.name = name;
        this.durationInDays = durationInDays;
        this.meals = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public double calculateDailyAverageCalories() {
        if (meals.isEmpty() || durationInDays <= 0) {
            return 0;
        }

        double totalCalories = 0;
        for (Meal meal : meals) {
            totalCalories += meal.calculateTotalCalories();
        }
        return totalCalories / durationInDays;
    }

    public List<Meal> getMeals() {
        return meals;
    }
}