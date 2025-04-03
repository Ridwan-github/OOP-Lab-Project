import java.util.List;

public class User {
    private String name;
    private double weight; // in kg
    private double height; // in cm
    private int age;
    private Gender gender;
    private ActivityLevel activityLevel;
    private List<Meal> consumedMeals;
    private MealPlan currentMealPlan;

    public User(String name, double weight, double height, int age, Gender gender, ActivityLevel activityLevel) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activityLevel=activityLevel;
        this.gender=gender;
    }

    public double calculateBMI() {
        return weight / Math.pow(height/100, 2);
    }
    public double calculateBMR() {
        if (gender == Gender.MALE) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }
    public double calculateDailyCalorieNeeds() {
        return calculateBMR() * activityLevel.getMultiplier();
    }

    public void addConsumedMeal (Meal meal){
        consumedMeals.add(meal);
    }
    public List<Meal> getConsumedMeals() {
        return consumedMeals;
    }
    public void setCurrentMealPlan(MealPlan mealPlan) {
        this.currentMealPlan = mealPlan;
    }

    public MealPlan getCurrentMealPlan() {
        return currentMealPlan;
    }


    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
}
