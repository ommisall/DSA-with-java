class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = (k % n);
        
        reverseArray(nums, n-k, n-1);
        reverseArray(nums, 0, n-k-1);
        reverseArray(nums, 0, n-1);        
    }

    public void reverseArray(int[] arr, int a, int b) {
       int start = a;
       int end = b;

       while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
       }
    }
}