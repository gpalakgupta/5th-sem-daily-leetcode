class Solution {
    public int numOfArrays(int n, int m, int k) {
        int[][][] dp = new int[101][51][51];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(0,0,0,n,m,k,dp);
    }
    public int helper(int max_val,int idx, int cost, int n, int m, int k, int[][][] dp){
        if(idx == n){
            if(cost == k){
                return 1;
            }
            return 0;
        }
        if(dp[max_val][idx][cost] != -1){
            return dp[max_val][idx][cost];
        }

        int mod = 1000000007;
        int result = 0;
          
        for(int i = 1; i<=m; i++){
            if(i > max_val){
                result = (result+helper(i,idx+1,cost+1,n,m,k,dp))%mod;
            }
            else{
                result = (result+helper(max_val,idx+1,cost,n,m,k,dp))%mod;
            }
        }
        return dp[max_val][idx][cost] = result;
    }
}