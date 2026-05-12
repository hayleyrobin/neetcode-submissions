class Solution {
    public int findMin(int[] nums) {
        // nums = [3,4,5,6,1,2]
        int left = 0, right = nums.length - 1;
        int result = nums[0];

        while(left <= right){
            // checks if left < right for non-rotated(already sorted) case
            if(nums[left] < nums[right]){
                result = Math.min(result, nums[left]); // update answer wih nums[left] & stop
                break;
            }
            int midpoint = left + (right - left) / 2;
            result = Math.min(result, nums[midpoint]);

            if(nums[midpoint] >= nums[left]){ // left half is sorted
                left = midpoint + 1;
            }
            else{ // right half is sorted
                right = midpoint - 1;
            }
        }
        return result; // points to smallest elmt
    }
}
