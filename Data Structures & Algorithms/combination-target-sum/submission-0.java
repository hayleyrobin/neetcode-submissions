class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums,0,0, subset, result, target);
        return result;
    }

    private void backtrack(int[] nums, int i, int total, List<Integer> s,List<List<Integer>> r, int target){
        if(total == target) {
            r.add(new ArrayList(s));
            return;
        }
        // base case : if currentsum > target or i > length of array, return
        if(i == nums.length || total > target) return;
        
        // add to subset
        s.add(nums[i]);
        total += nums[i];
        backtrack(nums, i, total, s, r, target);

        // remove from subset
        s.remove(s.size() - 1);
        total -= nums[i];
        backtrack(nums, i+1, total, s, r, target);
    }
}
