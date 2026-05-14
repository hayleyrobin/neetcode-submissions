class Solution {
    private static final int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        // empty grid 
        if(grid.length == 0) return 0;

        // get dimensions 
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;
         
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                // start bfs from 'land'cell
                if(grid[r][c] == '1'){
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int r, int c){
        // push starting cell into queue & mark as '0'
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r,c}); // [row1,col2]

        // while queue is not empty
        while(!q.isEmpty()){
            // pop a cell
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            
            // explore cell's 4 neighbors (up, down, left,right)
            for(int[] dir : directions){
                int nextR = row + dir[0], nextC = col + dir[1];

                // if a neighbor is land, mark at '0' & add to queue
                if(nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid[0].length && grid[nextR][nextC] == '1'){
                    q.add(new int[]{nextR, nextC});
                    grid[nextR][nextC] = '0';
                }
            }
        }
    }
}
