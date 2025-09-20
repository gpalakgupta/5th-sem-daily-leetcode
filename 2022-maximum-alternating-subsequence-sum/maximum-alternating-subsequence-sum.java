class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(long[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(nums,0,0,dp);
    }
    public long helper(int[] nums, int idx, int flag, long[][] dp){
        if(idx == nums.length){
            return 0;
        }
        if(dp[idx][flag] != -1){
            return dp[idx][flag];
        }
        long take = Integer.MIN_VALUE;
        long notake = Integer.MIN_VALUE;
        if(flag == 0){
            take = nums[idx] + helper(nums,idx+1,1,dp);
        }
        else if(flag == 1){
            take = -nums[idx]+helper(nums,idx+1,0,dp);
        }
        notake = helper(nums,idx+1,flag,dp);
        return dp[idx][flag] = Math.max(take,notake);
    }
}