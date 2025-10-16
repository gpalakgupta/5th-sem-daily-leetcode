class Solution {
    int n;
    public int change(int amount, int[] coins) {
        n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n+1][amount+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(amount,coins,0,dp);
    }
    public int helper(int amt, int[] coins, int idx, int[][] dp){
        if(amt == 0){
            return 1;
        }
        if(idx >= n){
            return 0;
        }

        if(dp[idx][amt] != -1){
            return dp[idx][amt];
        }

        int ans = 0;
        for(int i = idx; i<n; i++){
            if(amt- coins[i] >= 0){
                ans += helper(amt-coins[i],coins,i,dp);
            }
        }
        return dp[idx][amt] = ans;

    }
}