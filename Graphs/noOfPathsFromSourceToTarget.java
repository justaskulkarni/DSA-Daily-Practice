import java.util.List;
import java.util.ArrayList;

public class noOfPathsFromSourceToTarget {
     /*
    graph[][] is an Adjacency List
    Maintain an ArrayList curr 
    This arraylist stores a single path from source to destination
    Add the source to curr

    DFS:
    If source == destination then we have found a path 
    Add path to result
    Remove the last node in curr

    Add node to curr and perform dfs for that node

    */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0, curr, graph, graph.length - 1, res);
        return res;  
    }
    public void dfs(int src, List<Integer> curr, int graph[][], int dest,  List<List<Integer>> res){
        if(src == dest){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int a: graph[src]){
            curr.add(a);
            dfs(a, curr, graph, dest, res);
            curr.remove(curr.size() - 1);
        }
    }
}
