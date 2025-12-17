package tubes;

import java.util.ArrayList;
import java.util.List;

public class WeekList {
    public static List<Week> weekList = new ArrayList<>();
    static int weekAmount = 1;

    static {
        for(int i = 1; i <= 4; i++) {
            addWeek();
        }
    }

    public static void addWeek() {
        weekList.add(new Week(weekAmount));
        weekAmount++;
    }
}
