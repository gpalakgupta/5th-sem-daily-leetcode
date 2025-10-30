class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,s);
    }
    public int helper(int idx, String str){
        if(idx >= n){
            return 1;
        }

        if(str.charAt(idx) == '0'){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int res = helper(idx+1,str);
        if(idx+1 < n){
            if(str.charAt(idx) == '1' || (str.charAt(idx) == '2' && str.charAt(idx+1) <= '6')){
                res += helper(idx+2,str);
            }
        }
        return dp[idx] = res;
    }
}