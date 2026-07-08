class Solution {

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if (m > n) return -1;
        if (m == 0) return 0;

        long base = 31;
        long mod = 1000000007L;

        long needleHash = 0;
        long windowHash = 0;
        long power = 1;

        for (int i = 0; i < m; i++) {
            needleHash = (needleHash * base + (needle.charAt(i) - 'a' + 1)) % mod;
            windowHash = (windowHash * base + (haystack.charAt(i) - 'a' + 1)) % mod;

            if (i < m - 1)
                power = (power * base) % mod;
        }

        if (needleHash == windowHash && haystack.substring(0, m).equals(needle))
            return 0;

        for (int i = m; i < n; i++) {

            windowHash = (windowHash - ((haystack.charAt(i - m) - 'a' + 1) * power) % mod + mod) % mod;
            windowHash = (windowHash * base + (haystack.charAt(i) - 'a' + 1)) % mod;

            if (windowHash == needleHash) {
                int start = i - m + 1;
                if (haystack.substring(start, start + m).equals(needle))
                    return start;
            }
        }

        return -1;
    }
}