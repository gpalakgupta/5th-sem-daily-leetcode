class Solution {
    int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        return Math.min(helper(cost,0,dp1),helper(cost,1,dp2));
    }
    public int helper(int[] cost, int idx, int[] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int c1 = helper(cost,idx+1,dp);
        int c2 = helper(cost,idx+2, dp);
        return dp[idx] = Math.min(c1,c2)+cost[idx];
    }
}