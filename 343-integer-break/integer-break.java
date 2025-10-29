class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
    public int solve(int n, int[] dp){
        if(n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        int res = Integer.MIN_VALUE;
        for(int i = 1; i<n; i++){
            int mx = i*Math.max(n-i,solve(n-i,dp));
            res = Math.max(mx,res);
        }
        return dp[n] = res;
    }
}