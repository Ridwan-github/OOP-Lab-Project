import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract class HealthGoal {
    protected User user;
    protected int durationInDays;
    protected LocalDate startDate;

    public HealthGoal(User user, int durationInDays) {
        this.user = user;
        this.durationInDays = durationInDays;
        this.startDate = LocalDate.now();
    }

    public abstract boolean checkProgress();
    public abstract String getDescription();

    public int getDaysRemaining() {
        LocalDate currentDate = LocalDate.now();
        long daysPassed = ChronoUnit.DAYS.between(startDate, currentDate);
        return (int) Math.max(0, durationInDays - daysPassed);
    }
}