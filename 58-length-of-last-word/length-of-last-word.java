class Solution {
    public int lengthOfLastWord(String s) {
        int current = 0;
        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                if (current > 0) {
                    last = current;
                    current = 0;
                }
            } else {
                current++;
            }
        }

        return current == 0 ? last : current;
    }
}