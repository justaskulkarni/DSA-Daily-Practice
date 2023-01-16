package Tree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isMirror(root.left, root.right);      
    }
    public boolean isMirror(TreeNode leftNode, TreeNode rightNode){
        if(leftNode != null && rightNode != null)
            return leftNode.val == rightNode.val && isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
        return leftNode == rightNode;
    }    
}
