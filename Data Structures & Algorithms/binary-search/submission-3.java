class Solution {
    public int search(int[] nums, int target) {
         //Input: nums = [-1,0,2,4,6,8], target = 4
         int l = 0, r = nums.length - 1;

         while(l <= r){
            int mid = l + ((r - l) / 2);

            if(target > nums[mid]) l = mid + 1;
            else if(target < nums[mid]) r = mid - 1;
            else if(target == nums[mid]){
                return mid;
            }
         }
         return -1;
    }
}