class Solution {
    public int maxSubArray(int[] nums) {
        // nums: [2,-3,4,-2,2,1,-1,4]
        // two ptrs or sliding window
        int r = 1;
        int currentBest = nums[0];
        int overallBest = nums[0];

        while(r < nums.length){
            int x = nums[r]; // 2 + -3 = -1
            // extend prev subarray or start fresh?
            
            
            // is it better to add num to existing sum
            // or is this num on its own already larger than that combined sum
            // if prev sum was negative, always better to start over at current elemt
            if(currentBest + x > x) // 2+-3= -1 > -3
            {
                currentBest = currentBest + x;
            } else{
                currentBest = x;
            }

            if(currentBest > overallBest) overallBest = currentBest;
            
            r++;

        }
        return overallBest;
    }
}
