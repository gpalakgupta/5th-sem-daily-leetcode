class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        for(double[] a : dp){
            Arrays.fill(a,-1);
        }
        return Math.min(1.0,helper(poured, query_row, query_glass,dp));
    }
    public double helper(int poured, int i, int j, double[][] dp){
        if(i<0 || j < 0 || i<j){
            return 0.0;
        }

        if(i == 0 && j == 0){
            return poured;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        double left = (helper(poured, i-1,j-1,dp)-1)/2.0;
        double right = (helper(poured, i-1,j,dp)-1)/2.0;
        if(left < 0){
            left = 0;
        }
        if(right < 0){
            right = 0;
        }
        return dp[i][j] = left+right;
    }
}