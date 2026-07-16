import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length())
            return false;

        Map<Character, Character> forward = new HashMap<>();
        Map<Character, Character> backward = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (forward.containsKey(c1)) {
                if (forward.get(c1) != c2)
                    return false;
            } else {
                forward.put(c1, c2);
            }

            if (backward.containsKey(c2)) {
                if (backward.get(c2) != c1)
                    return false;
            } else {
                backward.put(c2, c1);
            }
        }

        return true;
    }
}