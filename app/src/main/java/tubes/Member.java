package TUBES_Stralgo.app.src.main.java.tubes;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberName;
    private List<Instrument> instrumentSpeciality = new ArrayList<>();
    private List<Week> availableWeeks = new ArrayList<>();

    public Member(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void addInstrumentSpeciality(Instrument instrument) {
        instrumentSpeciality.add(instrument);
    }

    public List<Instrument> getInstrumentSpeciality() {
        return instrumentSpeciality;
    }

    public void addAvailableWeek(Week week) {
        availableWeeks.add(week);
    }

    public List<Week> getAvailableWeek() {
        return availableWeeks;
    }
}
