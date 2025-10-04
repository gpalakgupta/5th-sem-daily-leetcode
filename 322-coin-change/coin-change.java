class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        int ans = helper(coins,amount,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public int helper(int[] coins, int amt, int[] dp){
        if(amt == 0){
            return 0;
        }
        if(amt < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[amt] != -1){
            return dp[amt];
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i<coins.length; i++){
            if(amt-coins[i] >= 0){
                int ans = helper(coins,amt-coins[i],dp);
                if(ans != Integer.MAX_VALUE){
                    res = Math.min(res,ans+1);
                }
            }
        }
        return dp[amt] = res;
    }
}