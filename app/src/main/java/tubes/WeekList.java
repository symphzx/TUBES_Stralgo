package TUBES_Stralgo.app.src.main.java.tubes;

import java.util.ArrayList;
import java.util.List;

public class WeekList {
    public static List<Week> weekList = new ArrayList<>();

    static {
        for(int i = 1; i <= 4; i++) {
            weekList.add(new Week(i));
        }
    }

    public void addWeek(Week week) {
        weekList.add(week);
    }
}
