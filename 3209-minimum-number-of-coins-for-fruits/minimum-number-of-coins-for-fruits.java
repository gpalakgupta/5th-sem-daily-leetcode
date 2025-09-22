class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(prices,dp,0);
    }
    public int helper(int[] prices, int[] dp, int idx){
        if(idx >= dp.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int cost = Integer.MAX_VALUE;
        for(int j = idx+1; j<=Math.min(dp.length,idx+idx+2);j++){
            cost = Math.min(cost,prices[idx]+helper(prices,dp,j));
        }
        return dp[idx] = cost;
    }
}