class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int[][] dp = new int[n][key.length()];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,0,ring,key,dp);
    }
    public int helper(int ringidx, int keyidx, String ring, String key, int[][] dp){
        if(keyidx >= key.length()){
            return 0;
        }
        if(dp[ringidx][keyidx] != -1){
            return dp[ringidx][keyidx];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<ring.length(); i++){
            if(ring.charAt(i) == key.charAt(keyidx)){
                int total = 1+count(i,ringidx,ring.length()) + helper(i,keyidx+1,ring,key,dp);
                ans = Math.min(ans,total);
            }
        }
        return dp[ringidx][keyidx] = ans;
    }
    public int count(int i, int j, int n){
        int a = Math.abs(i-j);
        int b = n-a;
        return Math.min(a,b);
    }
}