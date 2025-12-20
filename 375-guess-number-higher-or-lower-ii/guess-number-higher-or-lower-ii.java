class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] a : dp)
        Arrays.fill(a,-1);
        return helper(1,n,dp);
    }
    public int helper(int st, int end, int[][] dp){
        if(st >= end){
            return 0;
        }
        if(dp[st][end] != -1){
            return dp[st][end];
        }

        int min = Integer.MAX_VALUE;
        for(int i = st; i<=end; i++){
            min = Math.min(min,i+Math.max(helper(st,i-1,dp),helper(i+1,end,dp)));
        }
        return dp[st][end] = min;
    }
}