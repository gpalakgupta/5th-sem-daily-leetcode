class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,n-1,s,dp);
    }
    public int helper(int l, int r, String s, int[][] dp){
        if(l  == r){
            return 1;
        }
        if(l > r){
            return 0;
        }

        if(dp[l][r] != -1){
            return dp[l][r];
        }
        int i = l+1;
        while(i <= r && s.charAt(i) == s.charAt(l)){
            i++;
        }

        if(i == r+1){
            return 1;
        }

        int basic = 1+helper(i,r,s,dp);
        int lalach = Integer.MAX_VALUE;
        for(int j = i; j<= r; j++){
            if(s.charAt(j) == s.charAt(l)){
                int ans = helper(i,j-1,s,dp)+helper(j,r,s,dp);
                lalach = Math.min(ans,lalach);
            }
        }
        return dp[l][r] = Math.min(basic,lalach);
    }
}