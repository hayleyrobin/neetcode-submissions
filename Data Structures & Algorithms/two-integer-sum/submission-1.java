class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[3,4,5,6] taget=7
        int[] indices = new int[2];
        for(int i=0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        return indices; 
    }
}
