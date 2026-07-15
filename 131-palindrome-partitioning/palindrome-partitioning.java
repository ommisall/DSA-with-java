class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<>());
        return answer;
    }

    private void dfs(String s, int index, List<String> current) {

        if (index == s.length()) {
            answer.add(new ArrayList<>(current));
            return;
        }

        for (int end = index; end < s.length(); end++) {

            if (isPalindrome(s, index, end)) {

                current.add(s.substring(index, end + 1));

                dfs(s, end + 1, current);

                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }

        return true;
    }
}