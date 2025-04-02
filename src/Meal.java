import java.util.List;

public class Meal {
    private String name;
    private List<Food> foodItems;

    public Meal(String name, List<Food> foodItems) {
        this.name = name;
        this.foodItems = foodItems;
    }

    public void addFoodItem (Food food){
        foodItems.add(food);
    }

    public String getName() {
        return name;
    }
    public List<Food> getFoodItems() {
        return foodItems;
    }

    public double calculateTotalCalories(){
        double totalCalories = 0;
        for (Food food : foodItems) {
            totalCalories += food.getCalories();
        }
        return totalCalories;
    }
}
