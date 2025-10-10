class Solution {
    int n;
    int m;
    int[] row = { 0, -1, 0, 1 };
    int[] col = { -1, 0, 1, 0 };
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        int[][] dp = new int[n][m];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = (ans+helper(grid,i,j,dp))%mod;
            }
        }
        return ans;
    }

    public int helper(int[][] grid,int r, int c, int[][] dp) {
       if(dp[r][c] != -1){
        return dp[r][c];
       }
        int sum  = 1;
        for(int i = 0; i<4; i++){
            int cr = r+row[i];
            int cc = c+col[i];
            if(cr >= 0 && cc >= 0 && cr < n && cc < m && grid[cr][cc] > grid[r][c]){
                sum  = (sum+ helper(grid,cr,cc,dp))%mod;
            }
        }
        return dp[r][c] = sum%mod;
    }
}