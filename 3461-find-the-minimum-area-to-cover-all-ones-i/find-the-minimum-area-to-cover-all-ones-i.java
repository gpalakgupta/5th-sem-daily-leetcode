class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int a1 = -1;
        int a2 = -1;
        int b1 = -1;
        int b2 = -1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    a1 = i;
                }
            }
            if(a1 == i){
                break;
            }
        }
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    a2 = i;
                }
            }
            if(a2 == i){
                break;
            }
        }
        for(int j = 0; j<m; j++){
            for(int i = 0; i<n; i++){
                if(grid[i][j] == 1){
                    b1 = j;
                }
            }
            if(b1 == j){
                break;
            }
        }
        for(int j = m-1; j>=0; j--){
            for(int i = 0; i<n; i++){
                if(grid[i][j] == 1){
                    b2 = j;
                }
            }
            if(b2 == j){
                break;
            }
        }
        // System.out.println(a1);
        // System.out.println(a2);
        // System.out.println(b1);
        // System.out.println(b2);
        return (a2-a1+1)*(b2-b1+1);
    }
}