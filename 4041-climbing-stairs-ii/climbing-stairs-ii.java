class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(costs,n,0,dp);
    }
    public int helper(int[] costs, int n, int idx, int[] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i<=3; i++){
            int j = idx+i;
            if(j <= n){
                int jumpcost = costs[j-1]+(i*i);
                int next = helper(costs,n,j,dp);
                ans = Math.min(ans,jumpcost+next);
            }
        }
        return dp[idx] = ans;
    }
}