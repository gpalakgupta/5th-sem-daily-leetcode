class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(arr,k,0,dp);
    }
    public int helper(int[] arr, int k, int i, int[] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int ans = 0;
        int mx = -1;
        for(int j = i; j<arr.length && j-i+1 <= k; j++){
            mx = Math.max(mx,arr[j]);
            ans = Math.max(ans,((j-i+1)*mx)+helper(arr,k,j+1,dp));
        }
        return dp[i] = ans;
    }
}