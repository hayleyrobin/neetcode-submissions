class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix: outer array (row) * how many in each array (col)
        int ROWS = matrix.length; // matrix.length = outer array (rows)
        int COLS = matrix[0].length; // matrix[0].length = inner array (how many columns in first row)

        int firstRow = 0, lastRow = ROWS - 1;
        while(firstRow <= lastRow){
            int row = (firstRow + lastRow) / 2;
            if (target > matrix[row][COLS -1]){ // if target is larger than last elmt in middle row
                firstRow = row + 1; 
            }
            else if(target < matrix[row][0]) // if target is smaller than first elmt in middle row
            {
                lastRow = row - 1;
            } else{
                break;
            }
        }
        if(!(firstRow <= lastRow)) return false; // check if loop finished without finding potenital row
        
        int mid = (firstRow + lastRow) / 2; // get found row
        int l = 0, r = COLS -1; // search columns in row

        while(l <= r){
            int m = (l + r) / 2;
            if(target > matrix[mid][m]){
                l = m + 1;
            } 
            else if(target < matrix[mid][m]){
                r = m -1;
            }
            else{
                return true;
            }
        }
        return false; // target not found in row
    }
}
