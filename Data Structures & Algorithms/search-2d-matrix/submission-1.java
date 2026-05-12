class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // matrix: outer array (row) * how many in each array (col)
        int ROWS = matrix.length; // matrix.length = outer array (rows)
        int COLS = matrix[0].length; // matrix[0].length = inner array (how many columns in first row)

        int firstRow = 0, lastRow = ROWS - 1;
        while(firstRow <= lastRow){
            int row = firstRow + (lastRow - firstRow) / 2;
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
        
        int foundRow = (firstRow + lastRow) / 2; // get row that was found
        int l = 0, r = COLS -1; // search columns(each value) in row

        while(l <= r){
            int midPointValue = l + (r-l) / 2;
            if(target > matrix[foundRow][midPointValue]){
                l = midPointValue + 1;
            } 
            else if(target < matrix[foundRow][midPointValue]){
                r = midPointValue - 1;
            }
            else{
                return true;
            }
        }
        return false; // target not found in row
    }
}
