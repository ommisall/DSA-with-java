class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(nums, 0, ans);
        return ans;
    }

    private void generate(int[] nums, int index, List<List<Integer>> ans) {

        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            int t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;

            generate(nums, index + 1, ans);

            t = nums[index];
            nums[index] = nums[i];
            nums[i] = t;
        }
    }
}