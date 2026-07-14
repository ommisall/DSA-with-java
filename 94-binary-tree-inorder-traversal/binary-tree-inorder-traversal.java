class Solution {

    private List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);
        ans.add(node.val);
        traverse(node.right);
    }
}