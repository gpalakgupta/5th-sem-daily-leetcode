class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n][m];
        return helper(s,p,n-1,m-1,dp);
    }
    public boolean helper(String s, String p, int i, int j, Boolean[][] dp){
        if(i<0 && j<0){
            return true;
        }
        if(j<0){
            return false;
        }
        if(i<0){
            if(p.charAt(j) == '*'){
                return helper(s,p,i,j-2,dp);
            }
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean result = false;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
            result = helper(s,p,i-1,j-1,dp);
        }
        else if(p.charAt(j) == '*'){
            result = helper(s,p,i,j-2,dp);
            if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                result = result || helper(s,p,i-1,j,dp);
            }
        }
        return dp[i][j] = result;
    }
}