class Solution {
    public int orangesRotting(int[][] grid) {
        // minimum - BFS (while loop)
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int ROWS = grid.length, COLS = grid[0].length;
        int fresh = 0, minutes = 0;
        
        Queue<int[]> q = new ArrayDeque<>(); // has positions of rotten oranges
        
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == 1) fresh++;
                if(grid[r][c] == 2) q.offer(new int[]{r,c});
            }
        }

        while(!q.isEmpty() && fresh > 0){
            int queueLength = q.size(); // each level is 1 min of time
            for(int i = 0; i < queueLength; i++){
                int cell[] = q.poll(); 
                int row = cell[0], col = cell[1];
                
                // visit neighbors
                for(int dir[] : directions){                    
                    int nRow = row + dir[0], nCol = col + dir[1];
                    
                    // check if cell is not out of bounds, or is fresh
                    if(nRow >= 0 && nCol >= 0 && nRow < ROWS && nCol < COLS
                        && grid[nRow][nCol] == 1)
                    {
                        // if so, make it a rotten fruit
                        grid[nRow][nCol] = 2;
                        q.add(new int[]{nRow,nCol});
                        fresh--;
                    }
                }   
            } 
            minutes++;      
        }
        // if no fresh fruit left at the end or if any fresh fruit is left
        return (fresh == 0) ? minutes : -1;
    }
}
