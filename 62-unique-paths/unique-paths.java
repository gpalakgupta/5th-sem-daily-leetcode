class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,0,m-1,n-1,dp);
    }
    public int helper(int i, int j, int m, int n,int[][] dp){
        if(i == m && j == n){
            return 1;
        }
        if(i>m || j>n){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = helper(i+1,j,m,n,dp);
        int b = helper(i,j+1,m,n,dp);
        return dp[i][j] = a+b;
    }
}