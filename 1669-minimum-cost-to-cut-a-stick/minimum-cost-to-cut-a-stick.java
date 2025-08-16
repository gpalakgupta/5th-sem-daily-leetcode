class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] arr = new int[c+2];
        arr[0] = 0;
        Arrays.sort(cuts);
        for(int i = 0; i<c; i++){
            arr[i+1] = cuts[i];
        }
        arr[c+1] = n;
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(1,c,arr,dp);
    }
    public int helper(int i, int j, int[] arr, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int cost = arr[j+1]-arr[i-1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
}