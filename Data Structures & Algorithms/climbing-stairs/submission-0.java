class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0);
        
    }

    public int dfs(int steps, int current){
        if(current > steps) return 0; // if past the # of required steps, go back
        else if(current == steps) return 1;  // if at required steps, return 1
        return dfs(steps, current + 1) + dfs(steps, current + 2); // 
    }
}
