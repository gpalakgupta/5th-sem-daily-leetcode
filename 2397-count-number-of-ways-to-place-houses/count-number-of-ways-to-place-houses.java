class Solution {
    int mod = 1000000007;
    public int countHousePlacements(int n) {
        // if(n == 1){
        //     return 4;
        // }
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        long ans = helper(n,dp);
        long res = ans*ans;
        return (int)(res%mod);
    }
    public long helper(int n, long[] dp){
        if( n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 2;
        }

        if(dp[n] != -1){
            return dp[n];
        }
        long a = helper(n-1,dp);
        long b = helper(n-2,dp);
        return dp[n] = (a+b)%mod;  
    }
}