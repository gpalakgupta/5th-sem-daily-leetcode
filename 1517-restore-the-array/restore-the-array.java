class Solution {
    int mod = 1000000007;
    int n;
    public int numberOfArrays(String s, int k) {
        n = s.length();
        long[] dp = new long[n+1];
         
            Arrays.fill(dp,-1);
         
        return (int)helper(s,k,0,dp);
    }
    public long helper(String s, int k, int idx, long[] dp){
        if(idx >= n){
            return 1;
        }
        if(s.charAt(idx) == '0'){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        } 

        long num = 0;
        long ans = 0;
        for(int i = idx; i<n; i++){
            num = num*10+(s.charAt(i)-'0');
            if(num > k){
                break;
            }
            ans = (ans%mod+helper(s,k,i+1,dp)%mod)%mod;
        }
        return dp[idx] = ans%mod;
    }
}