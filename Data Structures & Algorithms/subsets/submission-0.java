class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> s = new ArrayList<>();
        dfs(nums, s, result, 0);
        return result;
    }
    // i == index of value we're deciding on
    private void dfs(int[] nums, List<Integer> subset, List<List<Integer>> r, int i){ 
        if(i >= nums.length) // base case
        {
            r.add(new ArrayList<>(subset)); // add a copy of subset to result array
            return;
        }
        
        // include in subset
        subset.add(nums[i]);
        dfs(nums, subset, r, i + 1);

        // dont include in subset
        subset.remove(subset.size() - 1); // remove from subset(backtrack)
        dfs(nums, subset, r, i + 1); //skip nums[i], got to next number
    }
}
