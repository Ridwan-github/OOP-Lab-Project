import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NutritionSystem {
    private List<User> users;
    private FoodList foodlist;
    private Map<User, List<HealthGoal>> userGoals;

    public NutritionSystem() {
        this.users = new ArrayList<>();
        this.foodlist = new FoodList();
        this.userGoals = new HashMap<>();
    }

    public void addUser(User user) {
        users.add(user);
        userGoals.put(user, new ArrayList<>());
    }

    public void addHealthGoal(User user, HealthGoal goal) {
        if (userGoals.containsKey(user)) {
            userGoals.get(user).add(goal);
        }
    }

    public FoodList getFoodList() {
        return foodlist;
    }

    public NutritionReport generateDailyReport(User user) {
        NutritionReport report = new NutritionReport(user);
        report.generateDailyStatistics();
        return report;
    }
}