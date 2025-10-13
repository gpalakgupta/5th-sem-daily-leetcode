class Solution {
    int mod = 1000000007;
    int N;
    int Goal;
    int K;
    public int numMusicPlaylists(int n, int goal, int k) {
        N = n;
        Goal = goal;
        K = k;
        long[][] dp = new long[goal+1][n+1];
        for(long[] a : dp){
            Arrays.fill(a,-1);
        }
        return (int)helper(0,0,dp);
    }
    public long helper(int count_unique, int count_song, long[][] dp){
        if(count_song == Goal){
            if(count_unique == N){
                return 1;
            }
            return 0;
        }
        if(dp[count_song][count_unique] != -1){
            return dp[count_song][count_unique];
        }

        long result = 0;

        if(count_unique < N){
            result += (N-count_unique) *  helper(count_unique+1,count_song+1,dp);
        }

        if(count_song > K ){
            result += (count_unique - K) * helper(count_unique,count_song+1,dp);
        }

        return dp[count_song][count_unique] = result %mod;

    }
}