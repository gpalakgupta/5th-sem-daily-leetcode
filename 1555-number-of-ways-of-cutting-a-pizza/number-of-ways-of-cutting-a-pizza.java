class Solution {
    int mod = 1000000007;
    int n;
    int m;

    public int ways(String[] pizza, int k) {
        n = pizza.length;
        m = pizza[0].length();
        int[][] apples = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                apples[i][j] = apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];
                if (pizza[i].charAt(j) == 'A') {
                    apples[i][j]++;
                }
            }
        }
        int[][][] dp = new int[n+1][m+1][k+1];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(apples, 0, 0, k,dp);
    }

    public int helper(int[][] apples, int i, int j, int k, int[][][] dp) {
        if (apples[i][j] < k) {
            return 0;
        }
        if (k == 1) {
            if (apples[i][j] >= 1) {
                return 1;
            }
            return 0;
        }

        if(dp[i][j][k] != -1){
            return dp[i][j][k];
        }

        int ans = 0;
        // horizontal
        for (int h = i + 1; h < n; h++) {
            int down = apples[h][j];
            int up = apples[i][j] - down;
            if (up >= 1 && down >= k - 1) {
                ans = (ans % mod + helper(apples, h, j, k - 1,dp) % mod) % mod;
            }
        }

        // vertical

        for (int v = j + 1; v < m; v++) {
            int right = apples[i][v];
            int left = apples[i][j] - right;
            if (left >= 1 && right >= k - 1) {
                ans = (ans % mod + helper(apples, i, v, k - 1,dp) % mod) % mod;
            }
        }

        return dp[i][j][k] = ans;
    }
}