class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[3,4,5,6] target=7
       
        // create copy of array
        int[][] copyNums= new int[nums.length][2]; //[rows][cols]:[value][idx]
        for(int i = 0; i < nums.length; i++){
            copyNums[i][0] = nums[i]; // value(1st col) for current row
            copyNums[i][1] = i; // idx(2ns col) for current row
        }
        
        // sort by the first element of each sub-array (a[0]), which is the value
        Arrays.sort(copyNums, Comparator.comparingInt(a -> a[0])); // this makes indices(2nd column) out of order btw
        
        // two pointers
        int left = 0, right = nums.length - 1;
        while(left < right){
            // check value (1st column) of each entry
            int current = copyNums[left][0] + copyNums[right][0];
            if(current == target){
                // return the indices (2nd column)
                return new int[]{Math.min(copyNums[left][1], copyNums[right][1]), Math.max(copyNums[left][1], copyNums[right][1])};
            }
            else if( current < target ) // too small - increase left
            {
                left++;
            }
            else{ // too big - decrease right
                right--;
            }
        }
        return new int[0];
    }
}
