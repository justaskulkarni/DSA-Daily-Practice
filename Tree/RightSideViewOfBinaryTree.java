package Tree;
import java.util.List;
import java.util.ArrayList;

public class RightSideViewOfBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        rightSideViewUtil(root, list, 0);
        return list;    
    }
    public void rightSideViewUtil(TreeNode root, ArrayList<Integer> list, int level){
        if(root == null)
            return;
        if(list.size() == level)
            list.add(root.val);
        rightSideViewUtil(root.right, list, level + 1);
        rightSideViewUtil(root.left, list, level + 1);
    }    
}
