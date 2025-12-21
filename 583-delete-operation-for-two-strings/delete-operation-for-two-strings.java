class Solution {
    public int minDistance(String word1, String word2) {
        return helper(word1,word2);
    }
    public int helper(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i<=m; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                int ans = 0;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    ans = dp[i-1][j-1];
                }
                else{
                    int a = dp[i-1][j];
                    int b = dp[i][j-1];
                    ans = Math.min(a,b)+1;
                }
                dp[i][j] = ans;
            }
        }
        return dp[n][m];
    }
}