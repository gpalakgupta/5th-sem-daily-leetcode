class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(prices,0,0,dp);
    }
    public int helper(int[] prices, int idx, int buy, int[][] dp){
        if(idx >= prices.length){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;
        if(buy == 0){
            int take = -prices[idx]+helper(prices,idx+1,1,dp);
            int notake = helper(prices,idx+1,buy,dp);
            profit  = Math.max(take,notake);
        }
        else{
            int sell = prices[idx]+helper(prices,idx+1,0,dp);
            int nosell = helper(prices,idx+1,buy,dp);
            profit  = Math.max(sell,nosell);
        }
        return dp[idx][buy] = profit;
    }
}