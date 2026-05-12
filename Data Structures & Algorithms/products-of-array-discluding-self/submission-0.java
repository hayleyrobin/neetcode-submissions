class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums = [1,2,4,6] -> [48,24,12,8]
        int[] result = new int[nums.length];

        for(int i =0; i < nums.length; i++){
            int product = 1;
            for(int j = 0; j < nums.length; j++){
                if(i != j){ // if not at the same index
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}  
