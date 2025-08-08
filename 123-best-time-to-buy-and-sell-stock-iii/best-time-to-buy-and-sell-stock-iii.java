class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n+1][2][3];
        // for(int[][] a : dp){
        //     for(int[] b : a){
        //         Arrays.fill(b,-1);
        //     }
        // }
        // return helper(0,1,2,n,prices,dp);
        return helper(prices);
    }
    public int helper(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                for(int k = 1; k<=2; k++){
                    int profit = 0;
                    if(j == 1){
                        int take = -prices[i]+dp[i+1][0][k];
                        int notake = dp[i+1][1][k];
                        profit = Math.max(take,notake);
                    }
                    else{
                        int sell = prices[i]+dp[i+1][1][k-1];
                        int nosell = dp[i+1][0][k];
                        profit = Math.max(sell,nosell);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }
            return dp[0][1][2];
    }
    // public int helper(int idx, int buy, int cap,int n, int[] prices, int[][][] dp){
    //     if(idx == n || cap == 0){
    //         return 0;
    //     }
    //     if(dp[idx][buy][cap] != -1){
    //         return dp[idx][buy][cap];
    //     }
    //     int profit = 0;
    //     if(buy == 1){
    //         int take = -prices[idx]+helper(idx+1,0,cap,n,prices,dp);
    //         int notake = helper(idx+1,1,cap,n,prices,dp);
    //         profit = Math.max(take,notake);
    //     }
    //     else{
    //         int sell = prices[idx]+helper(idx+1,1,cap-1,n,prices,dp);
    //         int nosell = helper(idx+1,0,cap,n,prices,dp);
    //         profit = Math.max(sell,nosell);
    //     }
    //     return dp[idx][buy][cap] = profit;
    // }
}