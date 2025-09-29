class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];
        int total = n*m;
        k%=total;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int idx = i*m+j;
                int newidx = (idx+k)%total;
                int r = newidx/m;
                int c = newidx%m;
                arr[r][c] = grid[i][j];
            }
        }
        for(int i = 0; i<grid.length; i++){
            List<Integer> ll = new ArrayList<>();
            for(int j = 0; j<grid[0].length; j++){
                ll.add(arr[i][j]);
            }
            ans.add(ll);
        }
        return ans;
    }
}