class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,0,n-1,dp) >= 0;
    }
    public int helper(int[] nums, int i, int j, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = nums[i] - helper(nums,i+1,j,dp);
        int b = nums[j] - helper(nums,i,j-1,dp);
        return dp[i][j] = Math.max(a,b);
    }
}