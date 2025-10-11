class Solution {
    int[] R = { 2, 2, -2, -2, 1, 1, -1, -1 };
    int[] C = { 1, -1, 1, -1, 2, -2, 2, -2 };

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(double[][] a : dp){
            for(double[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(n, k, row, column,dp);
    }

    public double helper(int n, int k, int r, int c, double[][][] dp) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }

        if(dp[k][r][c] != -1){
            return dp[k][r][c];
        }
        double ans = 0;
        for (int i = 0; i < 8; i++) {
            int cr = r + R[i];
            int cc = c + C[i];
            if (cr >= 0 && cc >= 0 && cr < n && cc < n) {
                ans += helper(n, k-1, cr, cc,dp);
            }
        }
        return dp[k][r][c] = (double) (ans) / 8;
    }
}