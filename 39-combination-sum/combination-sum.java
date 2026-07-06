import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);

        generate(candidates, target, 0, new ArrayList<>(), answer);

        return answer;
    }

    private void generate(int[] arr, int remaining, int start,
                          List<Integer> current,
                          List<List<Integer>> answer) {

        if (remaining == 0) {
            answer.add(new ArrayList<>(current));
            return;
        }

        int i = start;

        while (i < arr.length) {

            if (arr[i] > remaining)
                break;

            current.add(arr[i]);

            // Stay on same index because same element can be reused
            generate(arr, remaining - arr[i], i, current, answer);

            current.remove(current.size() - 1);

            i++;
        }
    }
}