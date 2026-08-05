/*
Understand
    In-place, move all 0's to END but maintaing order of other elemts
Input: arr of ints
Ouput: arr of ints, moving all 0's to end but maintaing order of other elemts

Match
    Two pointers because:
    - Must modify the array in-place, so avoid an extra array
        - right pointer: to scan for nonzero values
        - left: pointer to track where the next nonzero should be placed
    - Must preserve the relative order, so sorting is not allowed
Plan
    Initialize left = 0 to track where next non-0 is place
    For right is 0 to nums.length - 1
        if num != 0 :
            swap nums[right] and nums[left]
            left++
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 0 ){
                // non-zero
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
            }
        }
    }
}