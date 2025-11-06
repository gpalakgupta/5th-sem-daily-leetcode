class Solution {
    int n;
    long[][][] dp;
    public long maximumStrength(int[] nums, int k) {
        n = nums.length;
        dp = new long[n+1][k+1][2];
        for(long[][] a : dp){
            for(long[]  b : a){
                Arrays.fill(b,(long)(-1e18));
            }
        }
        return helper(nums,k,0,true);
    }
    public long helper(int[] nums, int k, int idx, boolean newst){
        if(k == 0){
            return 0;
        }
        if(idx >= n){
            return (long)(-1e18);
        }
        if(dp[idx][k][newst ? 1 : 0] != (long)(-1e18)){
            return dp[idx][k][newst ? 1 : 0];
        }
        long take = (long)(-1e18);
        long no_take = (long)(-1e18);
        if(newst){
            no_take = helper(nums,k,idx+1,newst);
        }
        if(k % 2 == 1){
            take = helper(nums,k-1,idx+1,true) + (long)nums[idx]*k;
            take = Math.max(take,helper(nums,k,idx+1,false)+(long)nums[idx]*k);
        }
        else{
              take = helper(nums,k-1,idx+1,true) - (long)nums[idx]*k;
            take = Math.max(take,helper(nums,k,idx+1,false)-(long)nums[idx]*k);
        }
        long ans = Math.max(take,no_take);
        return dp[idx][k][newst ? 1 : 0] = ans;
    }
}