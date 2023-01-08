package Tree;

public class LowestCommonAncestorofBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If node is null, or if one out of p and q is the root then the current node itself is the least common ancestor
        if(root == null || root == p || root == q)
            return root;
        // Perform postorder traversal. Search for the two node in left and right subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If recursive call of left subtree goes to null then clearly node is not in left subtree so search right subtree
        if(left == null)
            return right;
        // Similarly, if recursive call of right subtree goes to null then node is not in right subtree so search left subtree
        else if(right == null)
            return left;
        // If recursive calls of both go to null then root is LCA
        else
            return root;      
    }
}
