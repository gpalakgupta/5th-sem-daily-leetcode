class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int[][] dp = new int[21][10003];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(rods, 0, 0, dp)/2;
    }

    public int helper(int[] rods, int idx, int diff, int[][] dp) {
        if (idx >= rods.length) {
            if (diff == 0) {
                return 0;
            }
            return Integer.MIN_VALUE;
        }

        if(dp[idx][diff+5000] != -1){
            return dp[idx][diff+5000];
        }

        int notake = helper(rods, idx + 1, diff,dp);
        int take1 = rods[idx] + helper(rods, idx + 1, diff + rods[idx] ,dp);
        int take2 = rods[idx] + helper(rods, idx + 1, diff - rods[idx],dp);
        return dp[idx][diff+5000] = Math.max(notake, Math.max(take1 , take2));
    }
}