package tubes;

import java.util.ArrayList;
import java.util.List;

public class Ministry {
    public static List<Member> members = new ArrayList<>();


    static {
        Member member1 = new Member("Leon");
        member1.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0));
        member1.addAvailableWeek(WeekList.weekList.get(0));
        member1.addAvailableWeek(WeekList.weekList.get(1));
        addMember(member1);

        Member member2 = new Member("Jordan");
        member2.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1));
        member2.addAvailableWeek(WeekList.weekList.get(1));
        member2.addAvailableWeek(WeekList.weekList.get(2));
        addMember(member2);

        Member member3 = new Member("Josh");
        member3.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2));
        member3.addAvailableWeek(WeekList.weekList.get(2));
        member3.addAvailableWeek(WeekList.weekList.get(3));
        addMember(member3);

        Member member4 = new Member("Marvel");
        member4.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3));
        member4.addAvailableWeek(WeekList.weekList.get(0));
        member4.addAvailableWeek(WeekList.weekList.get(3));
        addMember(member4);
    }

    public static void addMember(Member newMember) {
        members.add(newMember);
    }
}
