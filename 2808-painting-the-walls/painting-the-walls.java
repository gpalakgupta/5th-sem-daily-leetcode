class Solution {
    int n;
    public int paintWalls(int[] cost, int[] time) {
        n = cost.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(cost,time,0,dp,n);
    }
    public int helper(int[] cost, int[] time, int idx, int[][] dp, int remaining){
        if(remaining <= 0){
            return 0;
        }
        if(idx >= n){
            return (int)(1e9);
        }
        if(dp[idx][remaining] != -1){
            return dp[idx][remaining];
        }

        int take = cost[idx]+helper(cost,time,idx+1,dp,remaining-1-time[idx]);
        int notake = helper(cost,time,idx+1,dp,remaining);
        return dp[idx][remaining] = Math.min(take,notake);
    }
}