import java.util.List;

public class FoodList {
    private List<Food> foodlist;

    public void addFood(Food food) {
        foodlist.add(food);
    }
    public void removeFood(Food food) {
        foodlist.remove(food);
    }

    public Food getFood(String name) {
        for (Food food : foodlist) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }
        return null;
    }

}
