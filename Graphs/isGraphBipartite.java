class isGraphBipartite {
    // DFS Graph Coloring Approach
    // From the property of bipartite graph we can say that it has a chromatic value of 2
    public boolean isBipartite(int[][] graph) {
        // Make an array to contain the color associated with each node in the graph
        int[] colorArray = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(colorArray[i] == 0 && !validColor(graph, colorArray, 1, i))
                return false;
        }
        return true;    
    }
    public boolean validColor(int[][] graph, int[] colorArray, int color, int nodeCount){
        // If node has already been visited, return true if color of the neighbouring node (that is, node calling the function) and this node are different else return false. Color conflict indicates violation of bipartite graph property
        if(colorArray[nodeCount] != 0)
            return colorArray[nodeCount] == color;
        // Color an uncolored node
        colorArray[nodeCount] = color;
        // For each of the neighbour, color with opposite color if neighbour not visited. If visited return false if there's a color conflict
        for(int neighbour: graph[nodeCount]){
            if(!validColor(graph, colorArray, -color, neighbour))
                return false;
        }
        return true;
    }
}