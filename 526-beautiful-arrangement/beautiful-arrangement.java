class Solution {
    int res = 0;
    public int countArrangement(int n) {
        int[] dp = new int[n+1];
        helper(dp,1,n);
        return res;
    }
    public void helper(int[] dp, int val, int n){
        if(val > n){
            res++;
            return;
        }

        for(int i = 1; i<=n; i++){
            if(dp[i] == 0 && (val % i == 0 || i % val == 0)){
                dp[i] = val;
                helper(dp,val+1,n);
                dp[i] = 0;
            }
        }
    }
}