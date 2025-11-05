class Solution {
    int[] dp;
    public int numSquares(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n);
    }
    public int helper(int n){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i*i<=n; i++){
            int res = 1+ helper(n-i*i);
            min = Math.min(min,res);
        }
        return dp[n] = min;
    }
}