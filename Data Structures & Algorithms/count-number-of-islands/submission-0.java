class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;

        // iterate through ever cell in grid
        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                // find neighbors of land
                if(grid[row][col] == '1'){
                    dfs(grid, row, col);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int row, int col){
        // base cases
        // if current island out of bounds, visited already, or blocked(water)
        if(row < 0 || col < 0 ||row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        // mark current cell a "0" (visited)
        grid[row][col] = '0';

        // visit all neighbors recursively
        for(int[] dir : directions){
            dfs(grid, row + dir[0], col + dir[1]);
        }
        /*dfs(grid, row + 1, col, visited);
        dfs(grid, row - 1, col, visited);
        dfs(grid, row, col + 1, visited);
        dfs(grid, row, col - 1, visited);*/
    }
}
