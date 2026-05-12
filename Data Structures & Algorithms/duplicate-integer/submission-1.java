class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for(int x : nums){
            if(numbers.contains(x)){
                return true;
            }
            else{
                numbers.add(x);
            }
        }
        return false;
    }
}