class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        // To reach step i, you can only come from:
        // step i - 1 (1 step)
        // step i - 2 (2 steps)
        // fibonacci-like pattern!
        
        int[] dp = new int[n+1]; // dp[i] = nums of ways to reach step i
        dp[1] = 1; // 1 way to reach step 1
        dp[2] = 2; // 2 ways to reach step 2: 1 + 1 or 2
        
        int i = 3;
        while(i <= n){
            // dp[4] = d[3] + d[2] = 3+2 = 5 ways
            dp[i] = dp[i - 1] + dp[i - 2]; 
            i++;
        }
        return dp[n]; // dp[4] = 5 steps
    }
}
