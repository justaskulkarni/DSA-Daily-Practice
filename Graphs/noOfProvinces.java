import java.util.*;

public class noOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        // Convert adjacency matrix into adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        int n = isConnected.length;

        // Add an empty ArrayList for each vertex

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        // Mark every edge in adjacency list
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }

        int ans = 0;
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                ans++;
                dfs(adj, i, vis);
            }
        }
        return ans;
    }

    public void dfs(List<List<Integer>> adj, int src, boolean[] vis) {
        vis[src] = true;
        for (int nbr : adj.get(src)) {
            if (vis[nbr] == false)
                dfs(adj, nbr, vis);
        }
    }    
}
