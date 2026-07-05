class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long quotient = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            long count = 1;

            while ((temp << 1) <= dvd) {
                temp <<= 1;
                count <<= 1;
            }

            dvd -= temp;
            quotient += count;
        }

        if ((dividend < 0) != (divisor < 0))
            quotient = -quotient;

        return (int) quotient;
    }
}