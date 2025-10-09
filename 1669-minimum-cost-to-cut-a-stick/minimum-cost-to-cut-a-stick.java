class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] arr = new int[cuts.length+2];
        arr[0] = 0;
        for(int i = 0; i<cuts.length; i++){
            arr[i+1] = cuts[i];
        }
        arr[arr.length-1] = n;
        int[][] dp = new int[arr.length+1][arr.length+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        } 
        return helper(1,cuts.length,arr,dp);
    }
    public int helper(int i, int j, int[] arr, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k<=j; k++){
            int res = arr[j+1]-arr[i-1]+helper(i,k-1,arr,dp)+helper(k+1,j,arr,dp);
            min = Math.min(res,min);
        }
        return dp[i][j] = min;
    }
}