class Solution {
    int n;
    int m;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(grid,0,0,m-1);
    }
    public int helper(int[][] grid, int r, int c1, int c2){
        if(r >= n){
            return 0;
        }
        if(dp[r][c1][c2] != -1){
            return dp[r][c1][c2];
        }
        int cherry = grid[r][c1];
        if(c1 != c2){
            cherry += grid[r][c2];
        }
        int ans = 0;
        for(int i = -1; i<=1; i++){
            for(int j = -1; j<=1; j++){
                int cc1 = c1+i;
                int cc2 = c2+j;
                if(cc1 >= 0 && cc1 < m && cc2 >= 0 && cc2 < m){
                    ans = Math.max(ans,helper(grid,r+1,cc1,cc2));
                }
            }
        }
        return dp[r][c1][c2] = ans+cherry;
    }
}