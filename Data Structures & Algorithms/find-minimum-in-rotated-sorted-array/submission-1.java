class Solution {
    public int findMin(int[] nums) {
        // nums = [3,4,5,6,1,2]
        int left = 0, right = nums.length - 1;

        while(left < right){
            int midpoint = left + (right - left) / 2;
            // checks if left < right for non-rotated case
            if(nums[midpoint] < nums[right]){ // minimum is on the left
                right = midpoint;
            }
            else{ // minimum is on right
                left = midpoint + 1;
            }
        }
        return nums[left]; // points to smallest elmt
    }
}
