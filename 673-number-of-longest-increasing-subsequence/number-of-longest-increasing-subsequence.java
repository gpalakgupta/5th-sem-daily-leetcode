class Solution {
    public int findNumberOfLIS(int[] nums) {
        return helper(nums);
    }
    public int helper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int mx = 1;
        Arrays.fill(dp,1);
        int[] count = new int[n];
        Arrays.fill(count,1);
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                }
                else if(dp[i] == dp[j]+1){
                    count[i]+=count[j];
                }
                
            }
            if(dp[i] > mx){
                mx = dp[i];
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            int el = dp[i];
            if(el == mx){
                ans+=count[i];
            }
        }
        return ans;
    }
}