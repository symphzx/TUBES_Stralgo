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

    public static void testCase1() {
        WeekList.weekList = new ArrayList<>();
        WeekList.weekAmount = 1;
        //4 minggu
        WeekList.addWeek();
        WeekList.addWeek();
        WeekList.addWeek();
        WeekList.addWeek();

        Ministry.members = new ArrayList<>();

        Member A = new Member("A");
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        A.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        A.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(A);

        Member B = new Member("B");
        B.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        B.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        B.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        B.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(B);

        Member C = new Member("C");
        C.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        C.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        C.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(C);

        Member D = new Member("D");
        D.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        D.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        D.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        D.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        D.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(D);

        Member E = new Member("E");
        E.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        E.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        E.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        E.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        E.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(E);

        Member F = new Member("F");
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        F.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        F.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        F.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        F.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(F);

        Member G = new Member("G");
        G.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Guitar
        G.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        G.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        G.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        G.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(G);

        Member H = new Member("H");
        H.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        H.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        H.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        H.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        H.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(H);

        Member I = new Member("I");
        I.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        I.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        I.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        I.addAvailableWeek(WeekList.weekList.get(2)); // Week 2
        I.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(I);
    }

    public static void testCase2() {
        WeekList.weekList = new ArrayList<>();
        WeekList.weekAmount = 1;
        //2 minggu
        WeekList.addWeek();
        WeekList.addWeek();

        Ministry.members = new ArrayList<>();

        Member A = new Member("A");
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        A.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(A);

        Member B = new Member("B");
        B.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        B.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(B);

        Member C = new Member("C");
        C.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        C.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(C);

        Member D = new Member("D");
        D.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // drum
        D.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(D);

        Member E = new Member("E");
        E.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Drum
        E.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        Ministry.addMember(E);

        Member F = new Member("F");
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        F.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        Ministry.addMember(F);

        Member G = new Member("G");
        G.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        G.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        Ministry.addMember(G);

        Member H = new Member("H");
        H.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        H.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        Ministry.addMember(H);
    }

    public static void defaultCase() {
        Member A = new Member("A");
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        A.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        A.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        A.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        Ministry.addMember(A);

        Member B = new Member("B");
        B.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        B.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        B.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        B.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(B);

        Member C = new Member("C");
        C.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        C.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        C.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        C.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(C);

        Member D = new Member("D");
        D.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        D.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        D.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        D.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(D);

        Member E = new Member("E");
        E.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(1)); // Bass
        E.addAvailableWeek(WeekList.weekList.get(0)); // Week 1
        E.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        E.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(E);

        Member F = new Member("F");
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(2)); // Drum
        F.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(3)); // Keyboard
        F.addAvailableWeek(WeekList.weekList.get(1)); // Week 2
        F.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        Ministry.addMember(F);

        Member G = new Member("G");
        G.addInstrumentSpeciality(InstrumentsList.instrumentsList.get(0)); // Gitar
        G.addAvailableWeek(WeekList.weekList.get(2)); // Week 3
        G.addAvailableWeek(WeekList.weekList.get(3)); // Week 4
        Ministry.addMember(G);
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

        testCase2();

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