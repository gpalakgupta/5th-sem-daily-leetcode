class Solution {
    public int maxProfit(int k, int[] prices) {
           int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return helper(prices, 0, 0, k, dp);
    }
     public int helper(int[] prices, int idx, int buy, int cap,int[][][]dp){
        if(idx >= prices.length || cap == 0){
            return 0;
        }
        if(dp[idx][buy][cap] != -1){
            return dp[idx][buy][cap];
        }
        int profit = 0;
        if(buy == 0){
            int take = -prices[idx]+helper(prices,idx+1,1,cap,dp);
            int notake = helper(prices, idx+1,buy,cap,dp);
            profit = Math.max(take,notake);
        }
        else{
            int sell = prices[idx]+helper(prices,idx+1,0,cap-1,dp);
            int nosell = helper(prices,idx+1,buy,cap,dp);
            profit = Math.max(sell,nosell);
        }
        return dp[idx][buy][cap] = profit;
    }
}