package TUBES_Stralgo.app.src.main.java.tubes;

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
        
        // Member member0 = new Member("leon2");
        // member0.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0));
        // member0.addAvailableWeek(WeekList.weekList.get(0));
        // member0.addAvailableWeek(WeekList.weekList.get(1));
        // addMember(member0);

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

        Member member5 = new Member("koji");
        member5.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1));
        member5.addAvailableWeek(WeekList.weekList.get(0));
        member5.addAvailableWeek(WeekList.weekList.get(3));
        addMember(member5);

        Member member6 = new Member("dipat");
        member6.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2));
        member6.addAvailableWeek(WeekList.weekList.get(0));
        member6.addAvailableWeek(WeekList.weekList.get(1));
        addMember(member6);

        
        Member member7 = new Member("peter");
        member7.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0));
        member7.addAvailableWeek(WeekList.weekList.get(2));
        member7.addAvailableWeek(WeekList.weekList.get(3));
        addMember(member7);


        Member member8 = new Member("rafli");
        member8.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3));
        member8.addAvailableWeek(WeekList.weekList.get(1));
        member8.addAvailableWeek(WeekList.weekList.get(2));
        addMember(member8);

    }

    public static void addMember(Member newMember) {
        members.add(newMember);
    }
}
