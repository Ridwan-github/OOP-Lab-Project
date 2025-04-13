class Food {
    private String name;
    private double calories;
    private double protein;
    private double carbs;
    private double fats;

    public Food(String name, double calories, double protein, double carbs, double fats) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public double getFats() {
        return fats;
    }
}