public class User {
    private String name;
    private double weight; // in kg
    private double height; // in cm
    private int age;

    public User(String name, double weight, double height, int age) {
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public double calculateBMI() {
        return weight / Math.pow(height/100, 2);
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
