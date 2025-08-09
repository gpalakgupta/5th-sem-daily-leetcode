class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n+1][2][k+1];
        // for(int[][] a : dp){
        //     for(int[] b : a){
        //         Arrays.fill(b,-1);
        //     }
        // }
        // return helper(0,1,k,prices,dp);
        return helper(prices,k);
    }
    public int helper(int[] prices,int k){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i = n-1; i>=0; i--){
            for(int buy = 0; buy<=1; buy++){
                for(int cap = 1; cap<=k; cap++){
                    int profit = 0;
                    if(buy == 1){
                        int take = -prices[i]+dp[i+1][0][cap];
                        int notake = dp[i+1][1][cap];
                        profit = Math.max(take,notake);
                    }
                    else{
                        int take = prices[i]+dp[i+1][1][cap-1];
                        int notake = dp[i+1][0][cap];
                        profit = Math.max(take,notake);
                    }
                    dp[i][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][k];
    }
    // public int helper(int i, int buy, int cap, int[] prices, int[][][] dp){
    //     if(i == prices.length || cap == 0){
    //         return 0;
    //     }
    //     if(dp[i][buy][cap] != -1){
    //         return dp[i][buy][cap];
    //     }
    //     int profit = 0;
    //     if(buy == 1){
    //         int take = -prices[i]+helper(i+1,0,cap,prices,dp);
    //         int notake = helper(i+1,1,cap,prices,dp);
    //         profit = Math.max(take,notake);
    //     }
    //     else{
    //         int sell = prices[i]+helper(i+1,1,cap-1,prices,dp);
    //         int nosell = helper(i+1,0,cap,prices,dp);
    //         profit = Math.max(sell,nosell);
    //     }
    //     return dp[i][buy][cap] = profit;
    // }
}