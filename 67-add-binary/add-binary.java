class Solution {
    public String addBinary(String a, String b) {

        int n = Math.max(a.length(), b.length());
        char[] ans = new char[n + 1];

        int i = a.length() - 1;
        int j = b.length() - 1;
        int k = n;
        int carry = 0;

        while (k >= 0) {

            int total = carry;

            if (i >= 0) {
                total += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                total += b.charAt(j--) - '0';
            }

            ans[k--] = (char) ('0' + (total & 1));
            carry = total >> 1;
        }

        if (ans[0] == '0') {
            return new String(ans, 1, n);
        }

        return new String(ans);
    }
}