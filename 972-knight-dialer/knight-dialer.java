class Solution {
    int mod = 1000000007;
    int[][] adj = {{4,6},{8,6},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{4,2}};
    int[][] dp;
    public int knightDialer(int n) {
        dp = new int[5001][10];
        for(int[] a: dp){
            Arrays.fill(a,-1);
        }
        int result = 0;
        for(int i = 0; i<=9; i++){
            result  = (result + dfs(n-1,i))%mod;
        }
        return result;
    }
    public int dfs(int n, int idx){
        if(n == 0){
            return 1;
        }
        if(dp[n][idx] != -1){
            return dp[n][idx];
        }
        int res = 0;
        for(int cell : adj[idx]){
            res = (res+dfs(n-1,cell))%mod;
        }
        return dp[n][idx] = res;
    }
}