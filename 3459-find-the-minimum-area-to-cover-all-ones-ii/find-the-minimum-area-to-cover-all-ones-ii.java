class Solution {
    public int minimumArea(int sr, int n, int sc, int m, int[][] grid) {
    int a1 = Integer.MAX_VALUE, a2 = -1, b1 = Integer.MAX_VALUE, b2 = -1;

    for (int i = sr; i < n; i++) {
        for (int j = sc; j < m; j++) {
            if (grid[i][j] == 1) {
                a1 = Math.min(a1, i);
                a2 = Math.max(a2, i);
                b1 = Math.min(b1, j);
                b2 = Math.max(b2, j);
            }
        }
    }

    if (a2 == -1) return 0;  
    return (a2 - a1 + 1) * (b2 - b1 + 1);
}


   public int helper(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int res = Integer.MAX_VALUE;

    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            int top = minimumArea(0, i, 0, m, grid);
            int bottomleft = minimumArea(i, n, 0, j, grid);
            int bottomright = minimumArea(i, n, j, m, grid);
            res = Math.min(res, top + bottomleft + bottomright);

            int topleft = minimumArea(0, i, 0, j, grid);
            int topright = minimumArea(0, i, j, m, grid);
            int bottom = minimumArea(i, n, 0, m, grid);
            res = Math.min(res, topleft + topright + bottom);
        }
    }

    for (int i = 1; i < n; i++) {
        for (int j = i + 1; j < n; j++) {    
            int top = minimumArea(0, i, 0, m, grid);
            int middle = minimumArea(i, j, 0, m, grid);
            int bottom = minimumArea(j, n, 0, m, grid);
            res = Math.min(res, top + middle + bottom);
        }
    }
    return res;
}


    public int minimumSum(int[][] grid) {
        int res = helper(grid);
        int[][] rotateGrid = rotate(grid);
        res = Math.min(res,helper(rotateGrid));
        return res;

    }
     
     
    public int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotateGrid = new int[m][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                rotateGrid[j][n-i-1] = matrix[i][j];
            }
        }
        return rotateGrid;
    }
}