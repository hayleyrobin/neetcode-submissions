class Solution {
    public int[] twoSum(int[] nums, int target) {
        //[3,4,5,6] taget=7
        HashMap<Integer,Integer> indices = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            indices.put(nums[i], i);
        }
        for(int j=0; j < nums.length; j++){
            int diff = target - nums[j];
            // check if diff is in hashmap and not the same number
            if(indices.containsKey(diff) && indices.get(diff) != j){
                return new int[]{j,indices.get(target - nums[j])};
            }

        }
        return new int[0]; 
    }
}
