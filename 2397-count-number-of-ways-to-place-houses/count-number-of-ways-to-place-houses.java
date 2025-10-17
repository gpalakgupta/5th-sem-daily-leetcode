class Solution {
    int mod = 1000000007;

    public int countHousePlacements(int n) {
       return (int) helper(n);
    }

    public long helper(int n){
         if(n == 1){
            return 4;
        }
        int[] dp = new int[n];
        dp[0] = 2;
        dp[1] = 3;
        for(int i = 2; i<n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return   ((long)dp[n-1]*dp[n-1]) %mod;
    }
}