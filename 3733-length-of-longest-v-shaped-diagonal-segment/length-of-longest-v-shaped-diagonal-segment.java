class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][][] dp = new int[n][m][4][2];
        for(int[][][] a : dp){
            for(int[][] b : a){
                for(int[] c : b){
                    Arrays.fill(c,-1);
                }
            }
        }
        int result = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    for(int d = 0; d<4; d++){
                        result = Math.max(result,1+solve(i,j,d,1,2,grid,dp));
                    }
                }
            }
        }
        return result;
    }
    public int solve(int i, int j, int d, int istrue, int val, int[][] grid, int[][][][] dp){
        if(dp[i][j][d][istrue] != -1){
            return dp[i][j][d][istrue];
        }
        int[][] direction = {{1,1},{1,-1},{-1,-1},{-1,1}};
        int i1 = i+direction[d][0];
        int j1 = j+direction[d][1];
        if(i1<0 || j1 <0 || i1 >= grid.length || j1 >= grid[0].length || val != grid[i1][j1]){
            return dp[i][j][d][istrue] = 0;
        }

        int result = 1+solve(i1,j1,d,istrue,val==2 ? 0 : 2 ,grid, dp);
        if(istrue == 1){
            result = Math.max(result,1+solve(i1,j1,(d+1)%4,0,val == 2 ? 0 : 2, grid, dp));
        }
        return dp[i][j][d][istrue] = result;
    }
}