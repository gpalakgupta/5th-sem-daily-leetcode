class Solution {
    int n;
    int m;
    public int getMaximumGold(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans,helper(grid,i,j));
                }
            }
        }
        return ans;
    }
    public int helper(int[][] grid, int cr, int cc){
        if(cr < 0 || cc < 0 || cr >= n || cc  >= m || grid[cr][cc] == 0){
            return 0;
        }
        int curr = grid[cr][cc];
        grid[cr][cc] = 0;
        int r = helper(grid,cr+1,cc);
        int l = helper(grid,cr,cc+1);
        int t = helper(grid,cr-1,cc);
        int d = helper(grid,cr,cc-1);


        grid[cr][cc] = curr;
        return Math.max(r,Math.max(l,Math.max(t,d)))+curr;
    }
}