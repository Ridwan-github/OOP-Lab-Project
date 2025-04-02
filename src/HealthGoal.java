import java.time.LocalDate;

public abstract class HealthGoal {
    protected User user;
    protected int days;
    protected LocalDate startDate;

    public HealthGoal(User user, int days) {
        this.user = user;
        this.days = days;
        this.startDate = LocalDate.now();
    }
    public abstract boolean isAchieved();
    public abstract String getDescription();
}
