class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1;
        for(int i = 0; i<n; i++){
            arr[i+1] = nums[i];
        }
        arr[n+1] = 1;
        int[][] dp = new int[n+3][n+3];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(1,n,arr,dp);
    }
    public int helper(int i, int j, int[] nums, int[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for(int k = i; k<=j; k++){
            int cost = nums[i-1]*nums[k]*nums[j+1]+helper(i,k-1,nums,dp)+helper(k+1,j,nums,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }
}