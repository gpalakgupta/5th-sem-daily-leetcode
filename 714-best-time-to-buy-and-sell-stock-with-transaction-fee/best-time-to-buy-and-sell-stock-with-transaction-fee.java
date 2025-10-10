class Solution {
    int n;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(prices,fee,0,0,dp);
    }
    public int helper(int[] prices, int fee, int idx, int by, int[][] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx][by] != -1){
            return dp[idx][by];
        }
        int buy = 0;
        int sell = 0;
        if(by == 0){
            int take  = -prices[idx]-fee+helper(prices,fee,idx+1,1,dp);
            int notake = helper(prices,fee,idx+1,0,dp);
            buy = Math.max(take,notake);
        }
        else{
            int take = prices[idx]+helper(prices,fee,idx+1,0,dp);
            int notake = helper(prices,fee,idx+1,1,dp);
            sell = Math.max(take,notake);
        }
        return dp[idx][by] = Math.max(buy,sell);
    }
}