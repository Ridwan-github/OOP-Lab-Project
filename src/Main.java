import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        NutritionSystem system = new NutritionSystem();


        initializeFoodlist(system.getFoodList());


        User user = createUserFromInput();
        system.addUser(user);

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    recordMeal(system, user);
                    break;
                case 2:
                    createMealPlan(system, user);
                    break;
                case 3:
                    createHealthGoal(system, user);
                    break;
                case 4:
                    viewNutritionReport(system, user);
                    break;
                case 5:
                    viewHealthAnalysis(system, user);
                    break;
                case 6:
                    addFoodTolist(system.getFoodList());
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Nutrition System!");
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n===== NUTRITION SYSTEM MENU =====");
        System.out.println("1. Record a meal");
        System.out.println("2. Create a meal plan");
        System.out.println("3. Set a health goal");
        System.out.println("4. View nutrition report");
        System.out.println("5. View health analysis");
        System.out.println("6. Add food to list");
        System.out.println("7. Exit");
        System.out.println("================================");
    }

    private static User createUserFromInput() {
        System.out.println("===== USER REGISTRATION =====");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        double weight = getDoubleInput("Enter your weight (kg): ");
        double height = getDoubleInput("Enter your height (cm): ");
        int age = getIntInput("Enter your age: ");

        System.out.println("Choose your gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        int genderChoice = getIntInput("Enter your choice: ");

        Gender gender = null;
        switch (genderChoice) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        System.out.println("Choose your activity level:");
        System.out.println("1. Inactive (little or no exercise)");
        System.out.println("2. Lightly Active (light exercise 1-3 days/week)");
        System.out.println("3. Moderate (moderate exercise 3-5 days/week)");
        System.out.println("4. Active (hard exercise 6-7 days/week)");
        System.out.println("5. Very Active (very hard exercise & physical job)");
        int activityChoice = getIntInput("Enter your choice: ");

        ActivityLevel activityLevel;
        switch (activityChoice) {
            case 1:
                activityLevel = ActivityLevel.INACTIVE;
                break;
            case 2:
                activityLevel = ActivityLevel.LIGHTLY_ACTIVE;
                break;
            case 3:
                activityLevel = ActivityLevel.MODERATE;
                break;
            case 4:
                activityLevel = ActivityLevel.ACTIVE;
                break;
            default:
                activityLevel = ActivityLevel.VERY_ACTIVE;
        }

        User user = new User(name, weight, height, age, gender, activityLevel);
        System.out.println("\nUser registered successfully!");
        System.out.println("Your daily calorie needs: " + String.format("%.2f", user.calculateDailyCalorieNeeds()) + " calories");
        System.out.println("Your BMI: " + String.format("%.2f", user.calculateBMI()));

        return user;
    }

    private static void initializeFoodlist(FoodList list) {
        list.addFood(new Food("Apple", 52, 0.3, 14.0, 0.2));
        list.addFood(new Food("Banana", 96, 1.2, 23.0, 0.2));
        list.addFood(new Food("Chicken", 165, 31.0, 0.0, 3.6));
        list.addFood(new Food("Broccoli", 55, 3.7, 11.0, 0.6));
        list.addFood(new Food("Almonds", 576, 21.0, 22.0, 49.0));
        list.addFood(new Food("Peanut Butter", 588, 25.0, 20.0, 50.0));
        list.addFood(new Food("Avocado", 160, 2.0, 9.0, 15.0));
        list.addFood(new Food("Beef", 500, 21.1, 21.0, 80.0));
        list.addFood(new Food("Fish", 206, 22.0, 0.0, 13.0));
        list.addFood(new Food("Brown Rice", 112, 2.6, 23.0, 0.9));
        list.addFood(new Food("White Rice", 130, 2.7, 28.0, 0.3));
        list.addFood(new Food("Spinach", 23, 2.9, 3.6, 0.4));
        list.addFood(new Food("Eggs", 78, 6.3, 0.6, 5.3));
        list.addFood(new Food("Oats", 68, 2.5, 12.0, 1.4));
        list.addFood(new Food("Yogurt", 59, 10.0, 3.6, 0.4));
        list.addFood(new Food("Potato", 77, 2.0, 17.6, 0.1));
        list.addFood(new Food("Carrot", 41, 0.9, 10.0, 0.2));
        list.addFood(new Food("Orange", 47, 0.9, 12.0, 0.1));
    }

    private static void addFoodTolist(FoodList list) {
        System.out.println("\n===== ADD FOOD TO list =====");
        System.out.print("Enter food name: ");
        String name = scanner.nextLine();

        double calories = getDoubleInput("Enter calories (per 100g): ");
        double protein = getDoubleInput("Enter protein (g per 100g): ");
        double carbs = getDoubleInput("Enter carbs (g per 100g): ");
        double fats = getDoubleInput("Enter fats (g per 100g): ");

        Food food = new Food(name, calories, protein, carbs, fats);
        list.addFood(food);

        System.out.println(name + " added to the food list successfully!");
    }

    private static void recordMeal(NutritionSystem system, User user) {
        System.out.println("\n===== RECORD A MEAL =====");
        System.out.print("Enter meal name: ");
        String mealName = scanner.nextLine();

        Meal meal = new Meal(mealName);

        boolean addingFoods = true;
        while (addingFoods) {

            List<Food> allFoods = system.getFoodList().getAllFoods();
            System.out.println("\nAvailable foods:");
            for (int i = 0; i < allFoods.size(); i++) {
                System.out.println((i + 1) + ". " + allFoods.get(i).getName());
            }
            System.out.println("0. Finish adding foods");

            int foodChoice = getIntInput("Select a food (0 to finish): ");
            if (foodChoice == 0) {
                addingFoods = false;
            } else if (foodChoice > 0 && foodChoice <= allFoods.size()) {
                Food selectedFood = allFoods.get(foodChoice - 1);
                double quantity = getDoubleInput("Enter quantity (in servings): ");
                meal.addFoodItem(selectedFood, quantity);
                System.out.println("Added " + quantity + " serving(s) of " + selectedFood.getName());
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        if (!meal.getFoodItems().isEmpty()) {
            user.recordMealConsumption(meal);
            System.out.println("\nMeal recorded successfully!");
            System.out.println("Total calories: " + String.format("%.2f", meal.calculateTotalCalories()));
        } else {
            System.out.println("\nNo foods added to the meal.");
        }
    }

    private static void createMealPlan(NutritionSystem system, User user) {
        System.out.println("\n===== CREATE MEAL PLAN =====");
        System.out.print("Enter meal plan name: ");
        String planName = scanner.nextLine();

        int duration = getIntInput("Enter duration in days: ");

        MealPlan mealPlan = new MealPlan(planName, duration);

        boolean addingMeals = true;
        while (addingMeals) {
            System.out.println("\n1. Add a new meal to the plan");
            System.out.println("2. Finish creating meal plan");

            int choice = getIntInput("Enter your choice: ");

            if (choice == 1) {
                System.out.print("Enter meal name: ");
                String mealName = scanner.nextLine();

                Meal meal = new Meal(mealName);

                boolean addingFoods = true;
                while (addingFoods) {

                    List<Food> allFoods = system.getFoodList().getAllFoods();
                    System.out.println("\nAvailable foods:");
                    for (int i = 0; i < allFoods.size(); i++) {
                        System.out.println((i + 1) + ". " + allFoods.get(i).getName());
                    }
                    System.out.println("0. Finish adding foods");

                    int foodChoice = getIntInput("Select a food (0 to finish): ");
                    if (foodChoice == 0) {
                        addingFoods = false;
                    } else if (foodChoice > 0 && foodChoice <= allFoods.size()) {
                        Food selectedFood = allFoods.get(foodChoice - 1);
                        double quantity = getDoubleInput("Enter quantity (in servings): ");
                        meal.addFoodItem(selectedFood, quantity);
                        System.out.println("Added " + quantity + " serving(s) of " + selectedFood.getName());
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }

                if (!meal.getFoodItems().isEmpty()) {
                    mealPlan.addMeal(meal);
                    System.out.println("\nMeal added to plan successfully!");
                } else {
                    System.out.println("\nNo foods added to the meal.");
                }
            } else {
                addingMeals = false;
            }
        }

        if (!mealPlan.getMeals().isEmpty()) {
            user.setCurrentMealPlan(mealPlan);
            System.out.println("\nMeal plan created successfully!");
            System.out.println("Daily average calories: " + String.format("%.2f", mealPlan.calculateDailyAverageCalories()));
        } else {
            System.out.println("\nNo meals added to the plan.");
        }
    }

    private static void createHealthGoal(NutritionSystem system, User user) {
        System.out.println("\n===== SET HEALTH GOAL =====");
        System.out.println("Goal types:");
        System.out.println("1. Weight goal");


        int goalType = getIntInput("Select goal type: ");

        if (goalType == 1) {
            double targetWeight = getDoubleInput("Enter target weight (kg): ");
            int duration = getIntInput("Enter goal duration (days): ");

            HealthGoal goal = new WeightGoal(user, targetWeight, duration);
            system.addHealthGoal(user, goal);

            System.out.println("\nHealth goal set successfully!");
            System.out.println("Goal: " + goal.getDescription());
        } else {
            System.out.println("Invalid goal type.");
        }
    }

    private static void viewNutritionReport(NutritionSystem system, User user) {
        System.out.println("\n===== NUTRITION REPORT =====");

        if (user.getConsumedMeals().isEmpty()) {
            System.out.println("No meals recorded yet. Record meals to generate a report.");
            return;
        }

        NutritionReport report = system.generateDailyReport(user);
        report.display();
    }

    private static void viewHealthAnalysis(NutritionSystem system, User user) {
        System.out.println("\n===== HEALTH ANALYSIS =====");

        if (user.getConsumedMeals().isEmpty()) {
            System.out.println("No meals recorded yet. Record meals to generate an analysis.");
            return;
        }

        HealthAnalyzer analyzer = new HealthAnalyzer();
        analyzer.analyzeNutrition(user);

        List<HealthGoal> goals = system.getUserGoals(user);
        if (!goals.isEmpty()) {
            for (HealthGoal goal : goals) {
                analyzer.trackGoalProgress(goal);
            }
        }

        System.out.println("Analysis results:");
        List<String> recommendations = analyzer.getRecommendations();
        if (recommendations.isEmpty()) {
            System.out.println("You're on track with your nutrition goals!");
        } else {
            for (String recommendation : recommendations) {
                System.out.println("- " + recommendation);
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}