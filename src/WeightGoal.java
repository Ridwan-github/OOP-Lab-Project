public class WeightGoal extends HealthGoal{
    private double targetWeight;
    private double currentWeight;

    public WeightGoal(User user, int days, double targetWeight) {
        super(user, days);
        this.targetWeight = targetWeight;
        this.currentWeight = user.getWeight();
    }

    @Override
    public boolean isAchieved() {
        return currentWeight <= targetWeight;
    }
    @Override
    public String getDescription() {
        return "Current weight is " + currentWeight +"kg. Reach " + targetWeight + " kg in " + days + " days";
    }

    public double getTargetWeight() {
        return targetWeight;
    }
}
