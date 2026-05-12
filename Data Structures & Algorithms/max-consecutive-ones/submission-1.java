class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int maxConsec = 0;

       for(int i = 0; i < nums.length; i++){
            int currentMax = 0;
        for(int j = i; j < nums.length; j++){
            if(nums[j] == 0){
                break;
            }
            currentMax++;   
        }
        maxConsec = Math.max(maxConsec, currentMax);
       } 
       return maxConsec;
    }
}