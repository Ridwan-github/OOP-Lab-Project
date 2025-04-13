public class WeightGoal extends HealthGoal {
    private double targetWeight;

    public WeightGoal(User user, double targetWeight, int durationInDays) {
        super(user, durationInDays);
        this.targetWeight = targetWeight;
    }

    @Override
    public boolean checkProgress() {
        double currentWeight = user.getWeight();
        return Math.abs(currentWeight - targetWeight) < 0.5;
    }

    @Override
    public String getDescription() {
        return "Reach " + targetWeight + "kg in " + durationInDays + " days";
    }

    public double getTargetWeight() {
        return targetWeight;
    }
}