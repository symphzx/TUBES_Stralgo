package TUBES_Stralgo.app.src.main.java.tubes;

public class DFS {
    private static boolean found;
    private static String[][] listPelayanan;

    public DFS() {
        found = false;
        listPelayanan = new String[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];
    }

    public static void jadwalPelayanan(int minggu) {
        if (found) {
            return;
        }

        if (minggu == WeekList.weekList.size()) {
            found = true;
            return;
        }

        for (int i = 0; i < InstrumentsList.instrumentsList.size(); i++) {
            boolean bisa = false;
            String nama = "";
            for (Member member : Ministry.members) {
                if (member.getInstrumentSpeciality().contains(InstrumentsList.instrumentsList.get(i)) &&
                        member.getAvailableWeek().contains(WeekList.weekList.get(minggu))) {
                    bisa = true;
                    nama = member.getMemberName();
                    break;
                }
            }
            if (!bisa) {
                return;
            } else {
                listPelayanan[minggu][i] = nama;
            }
        }
        jadwalPelayanan(minggu + 1);
    }

    public static void main(String[] args) {
        // for(Member member : Ministry.members) {
        // System.out.println("Member name: " + member.getMemberName() + " (Instrument
        // Specialty: " + member.getInstrumentSpeciality().get(0).getInstrumentName() +
        // ")");
        // System.out.print("Available weeks: ");
        // for(Week week : member.getAvailableWeek()) {
        // System.out.print(week.getWeekName() + ", ");
        // }
        // System.out.println("\n");
        // }

        // for (int i = 0; i < WeekList.weekList.size(); i++) {
        // for (int j = 0; j < InstrumentsList.instrumentsList.size(); j++) {
        // // listPelayanan[i][j] = 0;
        // }
        // }

        found = false;
        listPelayanan = new String[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];

        jadwalPelayanan(0);

        for (int i = 0; i < WeekList.weekList.size(); i++) {
            for (int j = 0; j < InstrumentsList.instrumentsList.size(); j++) {
                System.out.print(listPelayanan[i][j] + " ");
            }
            System.out.println();
        }

    }
}