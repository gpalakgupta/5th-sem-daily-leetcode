class Solution {
    int n;
    int[][][][] dp;
    public int getLengthOfOptimalCompression(String s, int k) {
        n = s.length();
        dp = new int[n+1][27][101][k+1];
        for(int[][][] a : dp){
            for(int[][] b : a){
                for(int[] c : b){
                    Arrays.fill(c,-1);
                }
            }
        }
        return helper(s,k,0,26,0);
    }
    public int helper(String s, int k, int idx, int pre_char,int freq){
      
        if(k < 0){
            return Integer.MAX_VALUE;
        }
          if(idx >= n){
            return 0;
        }
       
        if(dp[idx][pre_char][freq][k] != -1){
            return dp[idx][pre_char][freq][k];
        }

        int delete = helper(s,k-1,idx+1,pre_char,freq);
        int keep = 0;
        if(s.charAt(idx)-'a' == pre_char){
            int add = 0;
            if(freq == 1 || freq == 9 || freq == 99){
                add = 1;
            }
            keep = add+helper(s,k,idx+1,pre_char,freq+1);
        }
        else{
            keep = 1+helper(s,k,idx+1,s.charAt(idx)-'a',1);
        }
        return dp[idx][pre_char][freq][k] = Math.min(delete,keep);
    }
}