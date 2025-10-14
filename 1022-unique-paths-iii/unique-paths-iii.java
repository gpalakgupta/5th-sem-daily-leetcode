class Solution {
    int n;
    int m;
    int totalcnt = 0;
    public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int st = -1;
        int end = -1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    st = i;
                    end = j;
                }
                else if(grid[i][j] == 0){
                    totalcnt++;
                }
            }
        }
        return bfs(grid,st,end,-1);
    }
    public int bfs(int[][] grid, int r, int c, int cnt){
        if(r < 0 || c < 0 || r >= n || c>= m || grid[r][c] == -1){
            return 0;
        }
        if(grid[r][c] == 2){
            if(cnt == totalcnt){
                return 1;
            }
            return 0;
        }

        grid[r][c] = -1;
        int r1 = bfs(grid,r+1,c,cnt+1);
        int l = bfs(grid,r,c+1,cnt+1);
        int t = bfs(grid,r-1,c,cnt+1);
        int d = bfs(grid,r,c-1,cnt+1);
        grid[r][c] = 0;
        return r1+l+t+d;
    }
}