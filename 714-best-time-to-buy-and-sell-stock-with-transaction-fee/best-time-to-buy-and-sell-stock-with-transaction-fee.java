class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,1,n,prices,fee,dp);
    }
    public int helper(int idx, int buy, int n, int[] prices, int fee, int[][] dp){
        if(idx == n){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            int take = -prices[idx]-fee+helper(idx+1,0,n,prices,fee,dp);
            int notake = helper(idx+1,1,n,prices,fee,dp);
            profit = Math.max(take,notake);
        }
        else{
            int sell = prices[idx]+helper(idx+1,1,n,prices,fee,dp);
            int nosell = helper(idx+1,0,n,prices,fee,dp);
            profit = Math.max(sell,nosell);
        }
        return dp[idx][buy] = profit;
    }
}