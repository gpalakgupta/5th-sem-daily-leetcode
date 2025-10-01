class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n+1];
        return helper(nums,0,dp);
    }
    public boolean helper(int[] nums, int idx, Boolean[] dp){
        if(idx >= nums.length-1){
            return true;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        int el = nums[idx];
      
        for(int i = 1; i<=el; i++){
            int j = idx+i;
            boolean ans = helper(nums,j,dp);
            if(ans){
                return dp[idx] = ans;
            }
        }
        return dp[idx] = false;
    }
}