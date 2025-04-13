import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodList{
    private Map<String, Food> foods;

    public FoodList() {
        this.foods = new HashMap<>();
    }

    public void addFood(Food food) {
        foods.put(food.getName(), food);
    }

    public Food getFood(String name) {
        return foods.get(name);
    }

    public List<Food> getAllFoods() {
        return new ArrayList<>(foods.values());
    }
}
