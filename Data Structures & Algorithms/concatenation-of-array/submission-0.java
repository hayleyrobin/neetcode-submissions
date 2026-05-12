class Solution {
    public int[] getConcatenation(int[] nums) {
        // nums: nums = [1,4,1,2]
        int n = nums.length;
        int[] ans = new int[n * 2];
        for(int i = 0; i < n; i++){
            ans[i] = nums[i];
        }
        int j = 0;
        for(int i = n; i < ans.length; i++){
            ans[i] = nums[j++];
        }
        return ans;
    }
}