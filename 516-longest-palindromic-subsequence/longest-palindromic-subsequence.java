class Solution {
    public String rev(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
    public int longestPalindromeSubseq(String s) {
        String str = rev(s);
        // int n = str.length();
        // int[][] dp = new int[n+1][n+1];
        // for(int[] a : dp){
        //     Arrays.fill(a,-1);
        // }
        // return helper(s,str,0,0,dp);
        return helper(s,str);
    }

    public int helper(String s1, String s2){
        int n = s1.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                int taken = 0;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    taken = 1+dp[i-1][j-1];
                }
                else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    taken = Math.max(a,b);
                }
                dp[i][j] = taken;
            }
        }
        return dp[n][n];
    }
    // public int helper(String s1, String s2, int i, int j, int[][] dp){
    //     if(i >= s1.length() || j >= s2.length()){
    //         return 0;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     int taken = 0;
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         taken = 1+helper(s1,s2,i+1,j+1,dp);
    //     }
    //     else{
    //         int a = helper(s1,s2,i+1,j,dp);
    //         int b = helper(s1,s2,i,j+1,dp);
    //         taken = Math.max(a,b);
    //     }
    //     return dp[i][j] = taken;
    // }
}