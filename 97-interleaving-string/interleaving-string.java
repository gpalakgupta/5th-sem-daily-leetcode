class Solution {
    int n1;
    int n2;
    int n;

    public boolean isInterleave(String s1, String s2, String s3) {
        n1 = s1.length();
        n2 = s2.length();
        n = s3.length();
        if(n1+n2 != n){
            return false;
        }
        Boolean[][][] dp = new Boolean[n1][n2][n];
       
        return helper(0, 0, 0, s1, s2, s3,dp);
    }

    public boolean helper(int i, int j, int k, String s1, String s2, String s3, Boolean[][][] dp) {
        if (k >= n) {
            return true;
        }
        if (i >= n1 && j >= n2) {
            return false;
        }
        if (i >= n1) {
            boolean ans = false;
            if (s2.charAt(j) == s3.charAt(k)) {
                ans |= helper(i, j + 1, k + 1, s1, s2, s3,dp);
            }
            return ans;
        }
        if (j >= n2) {
            boolean ans = false;
            if (s1.charAt(i) == s3.charAt(k)) {
                ans |= helper(i + 1, j, k + 1, s1, s2, s3,dp);
            }
            return ans;
        }

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        boolean res = false;

        if (s1.charAt(i) == s3.charAt(k)) {
            res |= helper(i + 1, j, k + 1, s1, s2, s3,dp);
        }
        if (s2.charAt(j) == s3.charAt(k)) {
            res |= helper(i, j + 1, k + 1, s1, s2, s3,dp);
        }
        return dp[i][j][k] = res;
    }
}