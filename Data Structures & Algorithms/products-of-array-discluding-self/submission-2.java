class Solution {
    public int[] productExceptSelf(int[] nums) {
        // nums = [1,2,4,6] -> [48,24,12,8]
        int zeroCount = 0, product = 1;
        for( int num : nums){
            if(num == 0) zeroCount++;
            else{
                product *= num; // total product of array except 0's
            }
        }

        if(zeroCount > 1) return new int[nums.length];

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(zeroCount > 0){
                result[i] = (nums[i] == 0) ? product : 0;
            }else{
                result[i] = product / nums[i];
            }
        }
        return result;
    }
}  
