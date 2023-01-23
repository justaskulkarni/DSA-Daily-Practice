package Tree;
import java.util.*;

public class NodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        findParent(parentMap, root);
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(target);

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                // Mark node as visited
                visited.add(curr);
                if (k == 0)
                    res.add(curr.val);
                if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) // If parent is not visited then add it to the queue
                    q.add(parentMap.get(curr));
                if (curr.left != null && !visited.contains(curr.left)) // If node has left child and it is not visited, add it to queue
                    q.add(curr.left);
                if (curr.right != null && !visited.contains(curr.right)) // If node has right child and it is not visted, add it to queue                                             // visited, add it to queue
                    q.add(curr.right);
            }
            k--; // After traversing each level, the value of k is decremented
            if (k < 0)
                break;
        }
        return res;
    }

    public void findParent(HashMap<TreeNode, TreeNode> hm, TreeNode root) {
        // Child node is the key and it's parent is the value
        // If a node has a child then add the child to the hashmap as key and root as the value
        // Call this function recursively to find the parents of all nodes in the tree
        if (root == null)
            return;
        if (root.left != null)
            hm.put(root.left, root);
        if (root.right != null)
            hm.put(root.right, root);
        findParent(hm, root.left);
        findParent(hm, root.right);
    }    
}
