package tubes;

import java.util.ArrayList;
import java.util.List;

public class InstrumentsList {
    public static List<Instrument> instrumentsList = new ArrayList<>();

    static {
        addInstruments(new Instrument("Gitar"));
        addInstruments(new Instrument("Bass"));
        addInstruments(new Instrument("Drum"));
        addInstruments(new Instrument("Keyboard"));
    }

    public static void addInstruments(Instrument instrument) {
        instrumentsList.add(instrument);
    }
}
