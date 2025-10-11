class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int mx = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i] && dp[i] < dp[j]+1){
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                }
                else if(dp[i] == dp[j]+1){
                    count[i] += count[j];
                }
            }
            if(mx < dp[i]){
               mx = dp[i];
            }
        }
        int ans = 0;
        for(int i = 0; i<n; i++){
            if(dp[i] == mx){
                ans += count[i];
            }
        }
        return ans;
    }
}