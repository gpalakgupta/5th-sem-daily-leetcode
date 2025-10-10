class Solution {
    int n;
    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int res =  helper(stoneValue,0,dp);
        if(res > 0){
            return "Alice";
        }
        else if(res < 0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
    public int helper(int[] arr, int idx, int[] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int result = arr[idx]-helper(arr,idx+1,dp);
        if(idx+1 < n){
            result = Math.max(result,arr[idx]+arr[idx+1]-helper(arr,idx+2,dp));
        }
        if(idx+2 < n){
            result = Math.max(result,arr[idx]+arr[idx+1]+arr[idx+2]-helper(arr,idx+3,dp));
        }
        return dp[idx] = result;
    }
}