class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, occurence = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                continue;
            }
            nums[left] = nums[i];
            occurence++;
            left++;
        }
        return occurence;
    }
}