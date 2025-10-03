class Solution {
    int n;
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        n = s.length();
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return (int)helper(0,s,k,dp);
    }
    public long helper(int idx, String str, int k, long[] dp){
        if(idx >= n){
            return 1;
        }
        if(str.charAt(idx) == '0'){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        long ans = 0;
        long num = 0;
        for(int i = idx; i<n; i++){
            num = num*10+(str.charAt(i)-'0');
            if(num > k){
                break;
            }
            ans = (ans % mod + helper(i+1,str,k,dp)%mod)%mod;
        }
        return dp[idx] = ans;
    }
}