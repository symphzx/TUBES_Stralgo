package tubes;

import java.util.ArrayList;
import java.util.List;

public class Ministry {
    public static List<tubes.Member> members = new ArrayList<>();

    public static void addMember(Member newMember) {
        members.add(newMember);
    }
}
