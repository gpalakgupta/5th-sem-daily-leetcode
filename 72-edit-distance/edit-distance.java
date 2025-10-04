class Solution {
    int n1;
    int n2;
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(word1,word2,0,0,dp);
    }
    public int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i>=n1){
            return n2-j;
        }
        if(j>=n2){
            return n1-i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int take = 0;
        int notake = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            take = helper(s1,s2,i+1,j+1,dp);
        }
        else{
            int I = helper(s1,s2,i+1,j,dp);
            int d = helper(s1,s2,i+1,j+1,dp);
            int r = helper(s1,s2,i,j+1,dp);
            notake = Math.min(I,Math.min(d,r))+1;
        }
        return dp[i][j] = take+notake;
    }
}