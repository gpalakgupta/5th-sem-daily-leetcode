class Solution {
    int mod = 1000000007;
    public int numTilings(int n) {
        int[] dp = new int[1001];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    public int helper(int n, int[] dp){
        if(n == 1 || n == 2){
            return n;
        }
        if(n == 3){
            return 5;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = (((2*helper(n-1,dp))%mod) + (helper(n-3,dp)%mod))%mod;
    }
}