package Tree;

public class kthSmallestElementInBST {
    private static int number = 0;
    private static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        helper(root);
        return number;
    }
    // Go on calling recursively until you get to the leftmost node of the tree.
    // Process the left most node ie decrease count variable
    // Then process call for it's right sibling
    // Inorder DFS
    public void helper(TreeNode n) {
        if (n.left != null)
            helper(n.left);
        count--;
        if (count == 0) {
            number = n.val;
            return;
        }
        if (n.right != null)
            helper(n.right);
    }
}
