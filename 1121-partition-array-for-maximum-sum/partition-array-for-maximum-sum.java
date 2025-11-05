class Solution {
    int n;
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,k,0,dp);
    }
    public int helper(int[] arr, int k, int idx, int[] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int ans = 0;
        int mx = 0;
        for(int i = idx; i<n && (i-idx+1 <= k); i++){
            mx = Math.max(mx,arr[i]);
            ans = Math.max(ans,((mx*(i-idx+1)) + helper(arr,k,i+1,dp)));
        }
        return dp[idx] = ans;
    }
}