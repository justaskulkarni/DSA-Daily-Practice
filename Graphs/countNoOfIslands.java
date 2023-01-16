public class countNoOfIslands {
    /*
    DFS approach
    Visit each element in the matrix
    If the element is 0 (water) then do nothing
    If the element is 1 (land):
                                Mark it as visited (2)
                                Look up in all 4 directions of the visited land and if it is land then Mark it is as visited
    */
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0)       // Empty grid boundary case
            return 0;
        int cols = grid[0].length;    

        // Iterate for all cells of the array
        int noOfIslands = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    markCurrentIsland(grid, i, j, rows, cols);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    private void markCurrentIsland(char[][] grid, int x, int y, int r, int c){
        if(x < 0 || x >= r || y < 0 || y >= c || grid[x][y] != '1') // Boundary case for grid
            return;
        grid[x][y] = '2';
        // Make recursive calls in all 4 adjacent directions
        markCurrentIsland(grid, x + 1, y, r, c);    // Down
        markCurrentIsland(grid, x, y + 1, r, c);    // Right
        markCurrentIsland(grid, x - 1, y, r, c);    // Top 
        markCurrentIsland(grid, x, y - 1, r, c);    // Left
    }
}
