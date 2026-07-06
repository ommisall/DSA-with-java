class Solution {

    public boolean isValid(String s) {

        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            switch (ch) {

                case '(':
                    st.push(')');
                    break;

                case '{':
                    st.push('}');
                    break;

                case '[':
                    st.push(']');
                    break;

                default:
                    if (st.isEmpty() || st.pop() != ch) {
                        return false;
                    }
            }
        }

        return st.isEmpty();
    }
}