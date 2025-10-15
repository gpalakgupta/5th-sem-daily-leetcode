class Solution {
    int N;
    int Goal;
    int K;
    int mod = 1000000007;
    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        Goal = goal;
        K = k;
        long[][] dp = new long[101][101];
        for(long[] a : dp){
            Arrays.fill(a,-1);
        }
        return (int)helper(0,0,dp);
    }
    public long helper(int uni, int cnt, long[][] dp){
        if(cnt == Goal){
            if(uni == N){
                return 1;
            }
            return 0;
        }
        if(dp[uni][cnt] != -1){
            return dp[uni][cnt];
        }

        long res = 0;
        if(uni <  N){
            res += (N-uni) * helper(uni+1,cnt+1,dp);
        }
        if(K < uni){
            res += (uni-K) * helper(uni,cnt+1,dp);
        }
        return dp[uni][cnt] =  res%mod;
    }
}