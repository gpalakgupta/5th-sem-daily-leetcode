class Solution {
    public long maxScore(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        Long[][] dp = new Long[n1][n2];
        return helper(a,b,0,0,dp);
    }
    public long helper(int[] a, int[] b, int i, int j, Long[][] dp){
        if(i > a.length-1){
            return 0;
        }
        if(j >  b.length-1){
            return Long.MIN_VALUE/2;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        long take = (long) a[i]*b[j]+helper(a,b,i+1,j+1,dp);
        long notake = helper(a,b,i,j+1,dp);
        return dp[i][j] = Math.max(take,notake);
    }
}