class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int totalSum = sumOfArrayElements(nums);
        return (expectedSum - totalSum); 

    }

    public int sumOfArrayElements(int[] arr) {
        int sum = 0;
        int i = 0;
        while(i < arr.length) {
            sum = sum + arr[i];
            i++;
        }

        return sum;
    }
}