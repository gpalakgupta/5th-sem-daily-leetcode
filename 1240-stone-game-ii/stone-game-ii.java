class Solution {
    int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        int[][][] dp = new int[2][101][101];
        for(int[][] a : dp){
            for(int[] b : a){
                Arrays.fill(b,-1);
            }
        }
        return helper(piles,0,0,1,dp);
    }
    public int helper(int[] piles, int person, int idx, int m, int[][][] dp){
        if(idx >= n){
            return 0;
        }
        if(dp[person][idx][m] != -1){
            return dp[person][idx][m];
        }

        int res = (person == 0) ?  -1 : Integer.MAX_VALUE;
        int stone = 0;
        for(int i = 1; i<= Math.min(2*m,n-idx); i++){
            stone += piles[idx+i-1];
            if(person == 0){
                res = Math.max(res,stone+helper(piles,1,idx+i,Math.max(m,i),dp));
            }
            else{
                res = Math.min(res,helper(piles,0,idx+i,Math.max(m,i),dp));
            }
        }
        return dp[person][idx][m] = res;
    }
}