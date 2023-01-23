public class MaximumDifferenceBwNode&Ancestor {
    public int ans;
    public int maxAncestorDiff(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root, root.val, root.val);
        return ans;
    }
    public void dfs(TreeNode root, int max, int min){
        if(root == null)
            return;
        ans = Math.max(ans, Math.max(Math.abs(max - root.val), Math.abs(min - root.val)));
        dfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
        dfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
    }    
}
