class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][]dp = new int[n+1][2];
        for(int[] a : dp){
             
                Arrays.fill(a,-1);
            
        }
        return helper(0,1,n,prices,dp);
    }
    public int helper(int i, int buy, int n, int[] prices, int[][] dp){
        if(i >= n){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[i]+helper(i+1,0,n,prices,dp);
            int notake = helper(i+1,1,n,prices,dp);
            profit = Math.max(take,notake);
        }
        else{
            int sell = prices[i]+helper(i+2,1,n,prices,dp);
            int nosell = helper(i+1,0,n,prices,dp);
            profit = Math.max(sell,nosell);
        }
        return dp[i][buy] = profit;
    }
}