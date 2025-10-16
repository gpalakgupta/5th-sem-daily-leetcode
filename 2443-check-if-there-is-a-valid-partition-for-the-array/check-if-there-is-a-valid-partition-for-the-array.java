class Solution {
    int n;
    public boolean validPartition(int[] nums) {
        n = nums.length;
        Boolean dp[] = new Boolean[n];
        return helper(nums,0,dp);
    }
    public boolean helper(int[] nums, int i,Boolean[] dp){
        if(i >= n){
            return true;
        }

        if(dp[i] != null){
            return dp[i];
        }
        boolean res = false;
        if(i < n-1 && nums[i] == nums[i+1]){
            res |= helper(nums,i+2,dp);
        }
        if(i < n-2 && nums[i] == nums[i+1] && nums[i] == nums[i+2]){
            res |= helper(nums,i+3,dp);
        }
        if(i < n-2 && nums[i] == nums[i+1]-1 && nums[i] == nums[i+2]-2){
            res |= helper(nums,i+3,dp);
        }
        return dp[i] = res;
    }
}