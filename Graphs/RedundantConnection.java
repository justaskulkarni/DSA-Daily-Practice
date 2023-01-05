/*
 Problem Statement:
 Given an array which contains arrays of length 2 signifying the node betweeen which the edge exists
 The graph is originally a tree
 An edge is added to it which leads to the formation of a cycle
 Return that edge
 */
public class RedundantConnection {
    /*
    Approach:
    Make an array of n + 1 elements. An element in this array signifies the parent of the node.
    Initially, make every node as the parent of itself
    Whenever two nodes are linked by an edge the parent of one node is changed to the other.
    If we encounter 2 nodes, both having same parent then in that case we can say that a cycle exists in the graph. 
    */
    public int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        // The reason for having n + 1 elements: Indexing starts from 1 rather than 0 so using this approach
        // we need axes to indexes from 1 to n rather than 0 to n - 1. Here we get access to indexes 0 to n which suffices. We never use the node with 0 index
        parent = new int[edges.length + 1];
        //Make every node as parent of itself
        for(int i = 0; i <= edges.length; i++)
            parent[i] = i;
        for(int[] edge: edges){
            if(find(edge[0]) == find(edge[1]))
                return edge;
            union(edge[0], edge[1]);
        }
        return null;
    }
    // Returns the root node corresponding to any node in the graph
    public int find(int node){
        // Only root node has itself as its' parent
        while(parent[node] != node)
            node = parent[node];
        return node;
    }
    // If two nodes are linked by an edge, then the parent of the second node is changed and made as the first node
    public void union(int i, int j){
        int iRoot = find(i);
        int jRoot = find(j);

        // Making changes in jRoot because jRoot may be the root for nodes other than j as well, so in that case the updation happens for all it's descendents
        if(iRoot != jRoot)
            parent[jRoot] = iRoot;
    }
}