class Solution {

    class State {
        int index;
        int sum;
        List<Integer> list;

        State(int index, int sum, List<Integer> list) {
            this.index = index;
            this.sum = sum;
            this.list = list;
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();

        queue.offer(new State(0, 0, new ArrayList<>()));

        while (!queue.isEmpty()) {

            State curr = queue.poll();

            if (curr.sum == target) {
                ans.add(curr.list);
                continue;
            }

            for (int i = curr.index; i < candidates.length; i++) {

                if (i > curr.index && candidates[i] == candidates[i - 1])
                    continue;

                int newSum = curr.sum + candidates[i];

                if (newSum > target)
                    break;

                List<Integer> next = new ArrayList<>(curr.list);
                next.add(candidates[i]);

                queue.offer(new State(i + 1, newSum, next));
            }
        }

        return ans;
    }
}