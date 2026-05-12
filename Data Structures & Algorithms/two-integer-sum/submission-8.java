class Solution {
    public int[] twoSum(int[] nums, int target) {
        // [3,4,5,6] target = 7
        Map<Integer,Integer> indices = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int difference = target - num;
            if(indices.containsKey(difference)){ // if diff in map, found sum
                return new int[] {Math.min(indices.get(difference), i), Math.max(indices.get(difference), i)};// return sum and indices
            }
            else{
                indices.put(num, i);
            }
        }
        return new int[]{}; // final indices if sum not found
        
    }
}
