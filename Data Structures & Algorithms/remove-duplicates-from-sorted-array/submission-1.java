/**
Understand
In-place, Remove duplicates from nums so only unique elements appear ONCE
    Input: arr of ints, sorted in ascending order
    Output: int, unique elemts in nums after removing duplicates
    Case: [1,1,2] -> [1,2,_] k = 2

Match
    Two Pointers -> In-place duplicate removal on sorted array!
        left pointer = where to write non-duplicate(new unique number)
        right pointer = find unique number (non-duplicates)
Plan
    Initialize left = 0
    For right is 1 to nums.length-1
        if nums[right] != nums[left] // is unique!
            left++
            overwrite left num         
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for(int right = 1; right < nums.length; right++){
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}