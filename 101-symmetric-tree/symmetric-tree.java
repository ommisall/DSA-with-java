class Solution {
    public boolean isSymmetric(TreeNode root) {
        TreeNode p = root, q = root;
        return solve(p, q);
    }

    private boolean solve(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        boolean step1 = solve(p.left, q.right);
        if(!step1) return false;
        boolean step2 = solve(p.right, q.left);

        if(p.val == q.val && step1 && step2) return true;

        return false;
    }
}