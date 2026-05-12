class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int firstNum = nums[i];
            if(firstNum > 0) continue; // skip this loop if already > 0
            
            // skip duplicates for first number of loop
            if( i > 0 && firstNum == nums[i-1]) continue;

            // two ptrs for rest of sorted array
            int left = i + 1, right = nums.length - 1;

            while(left < right){
                int curSum = firstNum + nums[left] + nums[right];
                if(curSum > 0) right--;
                else if ( curSum < 0) left++;
                else {
                    result.add(Arrays.asList(firstNum, nums[left], nums[right]));
                    left++;
                    right--;

                    // skip duplicates at left pointer
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
