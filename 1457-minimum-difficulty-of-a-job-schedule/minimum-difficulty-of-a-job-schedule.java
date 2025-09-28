class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if ( n< d){
            return -1;
        }
        int[][] dp = new int[n+1][d+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(jobDifficulty,n,0,d,dp);
    }
    public int helper(int[] jobDifficulty, int n, int idx, int d, int[][] dp){
        if(d == 1){
            int mx = jobDifficulty[idx];
            for(int i = idx; i<n; i++){
                mx = Math.max(mx,jobDifficulty[i]);
            }
            return mx;
        }
        if(dp[idx][d] != -1){
            return dp[idx][d];
        }

        int result = Integer.MAX_VALUE;
        int mxd = jobDifficulty[idx];
        for(int i = idx; i<=n-d; i++){
            mxd = Math.max(mxd,jobDifficulty[i]);
            int res= mxd + helper(jobDifficulty,n,i+1,d-1,dp);
            result = Math.min(result,res);
        }
        return dp[idx][d] = result;
    }
}