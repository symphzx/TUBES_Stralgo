package TUBES_Stralgo.app.src.main.java.tubes;

public class Week {
    private int weekNumber;

    public Week(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public String getWeekName() {
        return "Week-" + weekNumber;
    }
}
