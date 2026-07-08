class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0"))
            return "0";

        String ans = "0";

        for (int i = num2.length() - 1; i >= 0; i--) {

            int digit = num2.charAt(i) - '0';

            String partial = multiplySingle(num1, digit);

            StringBuilder temp = new StringBuilder(partial);

            int zeros = num2.length() - 1 - i;   // <-- Move here

            while (zeros-- > 0) {
                temp.append('0');
            }

            ans = addStrings(ans, temp.toString());
        }

        return ans;
    }

    private String multiplySingle(String num, int digit) {

        if (digit == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = num.length() - 1; i >= 0; i--) {

            int product = (num.charAt(i) - '0') * digit + carry;

            sb.append(product % 10);
            carry = product / 10;
        }

        while (carry > 0) {
            sb.append(carry % 10);
            carry /= 10;
        }

        return sb.reverse().toString();
    }

    private String addStrings(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {

            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = x + y + carry;

            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}