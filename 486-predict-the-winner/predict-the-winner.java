class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,dp,0,n-1) >= 0;
    }
    public int helper(int[] nums, int[][] dp, int i, int j){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = nums[i] - helper(nums,dp,i+1,j);
        int b = nums[j] - helper(nums,dp,i,j-1);
        return dp[i][j] = Math.max(a,b);
    }
}