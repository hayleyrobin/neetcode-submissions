class Solution {
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, // up, down, left, right
                                {1,1},{-1,-1}, {1,-1}, {-1,1} }; // diagonals 
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        // shortest path - bfs (while loop)
        int ROWS = grid.length, COLS = grid[0].length;
        
        // check if 1st or last cell is blocked(1)
        if(grid[0][0] == 1 || grid[ROWS-1][ROWS-1] == 1) return -1;
        
        // track all visited vertices at each lvl & current lvl
        Queue<int[]> q = new LinkedList<>(); 
        boolean[][] visit = new boolean[ROWS][COLS];
        
        // starting cell (0,0) and length of current path!
        q.offer(new int[]{0, 0, 1}); 
        visit[0][0] = true; // already explored cell

        while(!q.isEmpty()){
            int[] cell = q.poll(); // get cell
            int row = cell[0], col = cell[1], curPathLen = cell[2]; // get row, col, curLen

            // If this is destination cell, return as shortest path
            if(row == ROWS - 1 && col == COLS - 1 ) return curPathLen;

            // visit neighbors
            for(int[] dir : directions){ 
                int nRow = row + dir[0], nCol = col + dir[1];
                
                // check if NOT out of bounds, NOT blocked (1) or NOT visited
                if(nRow >= 0 && nCol >= 0 && nRow < ROWS && nCol < COLS
                    && grid[nRow][nCol] == 0 && !visit[nRow][nCol] )
                    {
                        // add to queue; increase length by 1
                        q.offer(new int[]{nRow, nCol, curPathLen + 1}); 
                        visit[nRow][nCol] = true; // mark visited
                }
            }
        }
        return -1;   
    }
}