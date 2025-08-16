class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,n,s,dp)-1;
    }
    public int helper(int i, int n, String str, int[] dp){
        if(i == n){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;
        for(int j = i; j<n; j++){
            if(isvalid(i,j,str)){
                int cost = 1+helper(j+1,n,str,dp);
                minCost = Math.min(minCost,cost);
            }
        }
        return dp[i] = minCost;
    }
    public boolean isvalid(int i, int j, String str){
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}