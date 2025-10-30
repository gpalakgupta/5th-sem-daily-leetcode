class Solution {
     Boolean[][] dp ;
    public boolean isvalid(String str, int i, int j){
        if(i >= j){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        boolean ans = false;
        if(str.charAt(i) == str.charAt(j)){
            ans = isvalid(str,i+1,j-1);
        } 
        return dp[i][j] = ans;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n][n];
        int mxLen = 0;
        int st = 0;
        int end = 0;
        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                if(isvalid(s,i,j) && j-i+1 > mxLen){
                    mxLen = Math.max(mxLen,j-i+1);
                    st = i;
                    end = j;
                }
            }
        }
        return s.substring(st,end+1);
    }
}