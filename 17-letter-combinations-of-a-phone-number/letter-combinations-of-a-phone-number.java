class Solution {

    private final List<String> ans = new ArrayList<>();

    private static final Map<Character, char[]> phone = new HashMap<>();

    static {
        phone.put('2', new char[]{'a', 'b', 'c'});
        phone.put('3', new char[]{'d', 'e', 'f'});
        phone.put('4', new char[]{'g', 'h', 'i'});
        phone.put('5', new char[]{'j', 'k', 'l'});
        phone.put('6', new char[]{'m', 'n', 'o'});
        phone.put('7', new char[]{'p', 'q', 'r', 's'});
        phone.put('8', new char[]{'t', 'u', 'v'});
        phone.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0)
            return ans;

        char[] current = new char[digits.length()];
        build(digits, 0, current);

        return ans;
    }

    private void build(String digits, int index, char[] current) {

        if (index == digits.length()) {
            ans.add(new String(current));
            return;
        }

        char[] letters = phone.get(digits.charAt(index));

        for (char ch : letters) {
            current[index] = ch;
            build(digits, index + 1, current);
        }
    }
}