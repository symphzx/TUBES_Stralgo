package tubes;

import java.util.ArrayList;
import java.util.List;

public class Ministry {
    public static List<tubes.Member> members = new ArrayList<>();

    static {
        Member A = new Member("A");
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        A.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        A.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        A.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        addMember(A);

        Member B = new Member("B");
        B.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        B.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        B.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        B.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        addMember(B);

        Member C = new Member("C");
        C.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        C.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        C.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        C.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        addMember(C);

        Member D = new Member("D");
        D.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        D.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        D.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        D.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        addMember(D);

        Member E = new Member("E");
        E.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        E.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        E.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        E.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        addMember(E);

        Member F = new Member("F");
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        F.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        F.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        addMember(F);

        Member G = new Member("G");
        G.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        G.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        G.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        addMember(G);
    }

    public static void addMember(Member newMember) {
        members.add(newMember);
    }
}
