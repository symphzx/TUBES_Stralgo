package tubes.utils;

import tubes.Member;

public class utils {
    public static boolean find(Member[] array, Member value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return true;
        }
        return false;
    }
}
