class Solution {
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if(n < d){
            return -1;
        }
        int[][] dp = new int[n][d+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(jobDifficulty,0,d,dp);
    }
    public int helper(int[] arr, int idx, int d, int[][] dp){
        if(d == 1){
            int mx = Integer.MIN_VALUE;
            for(int i = idx; i<n; i++){
                mx = Math.max(mx,arr[i]);
            }
            return mx;
        }
        if(dp[idx][d] != -1){
            return dp[idx][d];
        }

        int mx = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for(int i = idx; i<=n-d; i++){
            mx = Math.max(mx,arr[i]);
            int res = mx+helper(arr,i+1,d-1,dp);
            result = Math.min(res,result);
        }
        return dp[idx][d] = result;
    }
}