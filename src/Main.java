public class Main {
    public static void main(String args[]){
        NutritionSystem system = new NutritionSystem();


        User user = new User("John", 90.0, 180.0, 30, Gender.MALE, ActivityLevel.MODERATELY_ACTIVE);
        system.addUser(user);

        system.getFoodList().addFood(new Food("Apple", 52));
        system.getFoodList().addFood(new Food("Chicken", 165));
        system.getFoodList().addFood(new Food("Rice", 112));
        system.getFoodList().addFood(new Food("Cashew Nuts", 23));


        Meal breakfast = new Meal("Breakfast");
        breakfast.addFoodItem(system.getFoodList().getFood("Apple"));
        breakfast.addFoodItem(system.getFoodList().getFood("Cashew Nuts"));

        Meal lunch = new Meal("Lunch");
        lunch.addFoodItem(system.getFoodList().getFood("Chicken"));
        lunch.addFoodItem(system.getFoodList().getFood("Rice"));

        weeklyPlan.addMeal(breakfast);
        weeklyPlan.addMeal(lunch);


        user.setCurrentMealPlan(weeklyPlan);
        user.recordMealConsumption(breakfast);


        HealthGoal weightGoal = new WeightGoal(user, 90.0, 70);
        system.addHealthGoal(user, weightGoal);


        NutritionReport analyzer = new NutritionReport(user);
        analyzer.analyzeNutrition(user);
        analyzer.display();
    }
    }
}
