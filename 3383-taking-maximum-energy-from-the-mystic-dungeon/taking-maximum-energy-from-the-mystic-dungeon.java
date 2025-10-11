class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        Integer[] dp = new Integer[n+1001];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans,helper(energy,i,k,dp));
        }
        return ans;
    }
    public int helper(int[] arr, int i, int k, Integer[] dp){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        return dp[i] = arr[i]+helper(arr,i+k,k,dp);
    }
}