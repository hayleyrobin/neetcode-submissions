class Solution {
    public int[] sortedSquares(int[] nums) {
        // two ptrs
        int[] squaredArr = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            squaredArr[i] = nums[i] * nums[i];
        }
        Arrays.sort(squaredArr);
        return squaredArr;
    }
}