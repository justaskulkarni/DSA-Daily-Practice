package Tree;

public class MaximumDepthofNnaryTree {
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        int h = 1;
        if(root != null){
            for(Node child: root.children)
                h = Math.max(h, 1 + maxDepth(child));
        }
        return h;
    }
}
