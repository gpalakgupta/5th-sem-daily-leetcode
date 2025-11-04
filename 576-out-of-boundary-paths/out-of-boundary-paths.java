class Solution {
    int mod = 1000000007;
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    int[][][] dp;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[51][51][51];
        for(int[][] a: dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(m,n,maxMove,startRow,startColumn);
    }
    public int helper(int m, int n, int mx, int str, int stc){
        if(str < 0 || stc < 0 || str >= m || stc >= n){
            return 1;
        }
        if(mx <= 0){
            return 0;
        }

        if(dp[mx][str][stc] != -1){
            return dp[mx][str][stc];
        }

        int res = 0;
        for(int[] arr : dir){
            int cr = str+arr[0];
            int cc = stc+arr[1];
            res = (res+helper(m,n,mx-1,cr,cc))%mod;
        }
        return dp[mx][str][stc] = res;
    }
}