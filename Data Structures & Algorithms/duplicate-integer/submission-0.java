class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> numbers = new HashMap<>();
        for(int num : nums){
            if(numbers.containsKey(num)){
                numbers.put(num,numbers.get(num) + 1);
            }
            else { numbers.put(num,1); }
        }
        for(Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if(entry.getValue() > 1){ return true;}
        }
        return false;
    }
}