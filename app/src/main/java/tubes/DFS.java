package tubes;

import tubes.utils.utils;

public class DFS {
    private static boolean found;
    private static Member[][] listPelayanan;

    public DFS() {
        found = false;
        listPelayanan = new Member[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];
    }

    public static void dfs(int minggu, int instrumen) {
        if(instrumen == InstrumentsList.instrumentsList.size()) {
            found = true;
            return;
        }
        if(minggu == WeekList.weekList.size()) {
            dfs(0, instrumen + 1);
            return;
        }

        for(Member member : Ministry.members) {
            if(utils.find(listPelayanan[minggu], member)) {
                continue;
            }
            if(!member.getInstrumentSpeciality().contains(InstrumentsList.instrumentsList.get(instrumen))) {
                continue;
            }
            if(!member.getAvailableWeek().contains(WeekList.weekList.get(minggu))) {
                continue;
            }

            listPelayanan[minggu][instrumen] = member;
            dfs(minggu + 1, instrumen);

            if(found) {
                return;
            }

            listPelayanan[minggu][instrumen] = null;
        }
    }

    public static void main(String[] args) {
        found = false;
        listPelayanan = new Member[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];

        dfs(0, 0);

        System.out.println(count);
        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s%n", "Minggu", "Guitar", "Bass", "Drum", "Keyboard");
        System.out.println("=".repeat(110));
        for (int i = 0; i < WeekList.weekList.size(); i++) {
            System.out.printf("| %-20s ", WeekList.weekList.get(i).getWeekName());
            for (int j = 0; j < InstrumentsList.instrumentsList.size(); j++) {
                System.out.printf("| %-20s ", listPelayanan[i][j] == null ? "-" : listPelayanan[i][j].getMemberName());
            }
            System.out.println();
        }

    }
}