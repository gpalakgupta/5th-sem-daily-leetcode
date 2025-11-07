class Solution {
    int n;
    // HashMap<String,Integer> map = new HashMap<>();
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        // map.clear();
        dp = new int[n][n][n];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        // return Math.max(0,helper(0,0,0,0,grid));
         return Math.max(0,helper(0,0,0,grid));

    }
    // public int helper(int r1, int c1, int r2, int c2, int[][] grid){
     public int helper(int r1, int c1, int r2, int[][] grid){
        int c2 = r1+c1-r2;
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        if (r1 == n-1 && c1 == n-1) return grid[r1][c1];

        // String key = r1+"-"+r2+"-"+c1+"-"+c2;
        // if(map.containsKey(key)){
        //     return map.get(key);
        // }

        if(dp[r1][r2][c1] != -1){
            return dp[r1][r2][c1];
        }

        int cherry = grid[r1][c1];
        if(r1 != r2 || c1 != c2){
            cherry += grid[r2][c2];
        }
        // int a = helper(r1+1,c1,r2+1,c2,grid);
        // int b = helper(r1+1,c1,r2,c2+1,grid);
        // int c = helper(r1,c1+1,r2+1,c2,grid);
        // int d = helper(r1,c1+1,r2,c2+1,grid);

        int a = helper(r1+1,c1,r2+1,grid);
        int b = helper(r1+1,c1,r2,grid);
        int c = helper(r1,c1+1,r2+1,grid);
        int d = helper(r1,c1+1,r2,grid);
        int best = Math.max(Math.max(a,b),Math.max(c,d));
        if(best == Integer.MIN_VALUE){
            // map.put(key,best);
            return dp[r1][r2][c1] = best;
        }
        // map.put(key,best+cherry);
        return dp[r1][r2][c1] = best+cherry;
    }
}