class Solution {
    int n;
   int[][] dp;
    public int stoneGameVII(int[] stones) {
        n = stones.length;
        int sum = 0;
        for(int el : stones){
            sum += el;
        }
      
        dp = new int[1001][1001];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(stones,0,0, n-1,sum);
    }
    public int helper(int[] stones, int st, int canAlice, int end, int total){
        if(st > end){
            return 0;
        }

       
        if(dp[st][end] != -1){
            return dp[st][end];
        }
        int ans = 0;
        if(canAlice == 0){
            int takest = total - stones[st] + helper(stones,st+1,1,end,total-stones[st]);
            int takelt = total - stones[end] + helper(stones,st,1, end-1,total-stones[end]);
            ans = Math.max(takest,takelt);
        }
        else{
            int removest = -(total-stones[st]) + helper(stones,st+1,0,end,total-stones[st]);
            int removelt = -(total-stones[end]) + helper(stones,st,0,end-1,total-stones[end]);
            ans = Math.min(removest,removelt);
        }
        
        return dp[st][end] = ans;
    }
}