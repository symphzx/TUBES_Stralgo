package tubes;

import tubes.utils.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    private static boolean found;
    static Scanner sc = new Scanner(System.in);
    private static Member[][] listPelayanan;
    private static List<Member[][]> solutionsFoundList = new ArrayList<>();

    public DFS() {
        found = false;
        listPelayanan = new Member[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];
    }

    public static void dfs(int minggu, int instrumen) {
        if (instrumen == InstrumentsList.instrumentsList.size()) {
            if (!solusionExist()) {
                solutionsFoundList.add(copyArray(listPelayanan));
                found = true;
            }
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

    public static void refreshArray() {
        listPelayanan = new Member[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];
    }

    public static boolean solusionExist() {
        for (Member[][] solution : solutionsFoundList) {
            if (solution.length != listPelayanan.length ||
                    solution[0].length != listPelayanan[0].length) {
                continue;
            }
            boolean same = true;
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution[i].length; j++) {
                    if (solution[i][j] != listPelayanan[i][j]) {
                        same = false;
                        break;
                    }
                }
                if (!same) break;
            }
            if (same) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        found = false;
        listPelayanan = new Member[WeekList.weekList.size()][InstrumentsList.instrumentsList.size()];

        int menu = 0;
        do {
            System.out.println("1. Find Solution\n" +
                    "2. View instrument list\n" +
                    "3. Add new instrument\n" +
                    "4. View members list\n" +
                    "5. Add new member\n" +
                    "6. View weeks list\n" +
                    "7. Add new week\n" +
                    "0. Exit");
            menu = sc.nextInt();
            switch(menu) {
                case 1:
                    refreshArray();
                    System.out.println("=========================================");
                    dfs(0, 0);
                    display();
                    found = false;
                    System.out.println("=========================================");
                    break;
                case 2:
                    System.out.println("=========================================");
                    viewInstrumentList();
                    System.out.println("=========================================");
                    break;
                case 3:
                    System.out.println("=========================================");
                    sc.nextLine();
                    System.out.println("Masukkan nama instrumen/role");
                    String instrumentName = sc.nextLine();
                    InstrumentsList.instrumentsList.add(new Instrument(instrumentName));
                    System.out.println("=========================================");
                    break;
                case 4:
                    System.out.println("=========================================");
                    viewMembersList();
                    System.out.println("=========================================");
                    break;
                case 5:
                    System.out.println("=========================================");
                    addMember();
                    System.out.println("=========================================");
                    break;
                case 6:
                    System.out.println("=========================================");
                    viewWeeksList();
                    System.out.println("=========================================");
                    break;
                case 7:
                    WeekList.addWeek();
                    break;
            }
        } while(menu != 0);
    }

    public static Member[][] copyArray(Member[][] source) {
        Member[][] copy = new Member[source.length][source[0].length];
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, copy[i], 0, source[i].length);
        }
        return copy;
    }

    public static void viewWeeksList() {
        int count = 1;
        for(Week week : WeekList.weekList) {
            System.out.print(count++ + ". ");
            System.out.println(week.getWeekName());
        }
    }

    public static void viewMembersList() {
        int count = 1;
        for(Member member : Ministry.members) {
            System.out.print(count++ + ". ");
            System.out.println(member.toString());
        }
    }

    public static void viewInstrumentList() {
        int count = 1;
        for(Instrument instrument : InstrumentsList.instrumentsList) {
            System.out.print(count++ + ". ");
            System.out.println(instrument.getInstrumentName());
        }
    }

    public static void addMember() {
        sc.nextLine();
        System.out.println("Masukkan nama anggota");
        String memberName = sc.nextLine();
        Member newMember = new Member(memberName);
        int menu  = 0;
        do {
            System.out.println("    1. Add new instrument specialty\n" +
                    "   2. Add new available week\n" +
                    "   0. Exit");
            menu = sc.nextInt();
            switch(menu) {
                case 1:
                    viewInstrumentList();
                    int instrument = sc.nextInt();
                    newMember.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(instrument - 1));
                    break;
                case 2:
                    viewWeeksList();
                    int week = sc.nextInt();
                    newMember.addAvailableWeek(WeekList.weekList.get(week - 1));
                    break;
            }
        } while(menu != 0);
        Ministry.addMember(newMember);
    }

    public static void display() {
        int colWidth = 20;

        System.out.printf("| %-"+colWidth+"s ", "Minggu");
        for (Instrument instrument : InstrumentsList.instrumentsList) {
            System.out.printf("| %-"+colWidth+"s ", instrument.getInstrumentName());
        }
        System.out.println("|");
        for (int i = 0; i < WeekList.weekList.size(); i++) {
            System.out.printf("| %-20s ", WeekList.weekList.get(i).getWeekName());
            for (int j = 0; j < InstrumentsList.instrumentsList.size(); j++) {
                System.out.printf("| %-20s ", listPelayanan[i][j] == null ? "-" : listPelayanan[i][j].getMemberName());
            }
            System.out.println();
        }
    }
}