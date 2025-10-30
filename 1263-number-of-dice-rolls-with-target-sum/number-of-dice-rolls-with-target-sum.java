class Solution {
    int mod = 1000000007;
    int[][] dp;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[31][1001];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(n,k,target);
    }
    public int helper(int n, int k, int target){
        if(target < 0){
            return 0;
        }
        if(n == 0){
            return target == 0 ? 1 : 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int res = 0;
        for(int i = 1; i<=k; i++){
            res = (res+helper(n-1,k,target-i))%mod;
        }
        return dp[n][target] = res;
    }
}