class Solution {
    int n;
    int m;
    int mod = 1000000007;
    public int numWays(String[] words, String target) {
        n = target.length();
        m = words[0].length();

        int[][] freq = new int[26][m];
        for(String str : words){
            for(int j = 0; j<str.length(); j++){
                freq[str.charAt(j)-'a'][j]++;
            }
        }
        // for(int[] arr : freq){
        //     for(int el : arr){
        //         System.out.print(el+" ");
        //     }
        //     System.out.println();
        // }

        long[][] dp = new long[1001][1001];
        for(long[] a : dp){
            Arrays.fill(a,-1);
        }
        return (int)helper(freq,target,0,0,dp);

    }
    public long helper(int[][] freq, String target, int i, int j, long[][] dp){
        if(i >= n){
            return 1;
        }
        if(j>= m){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        long notake = helper(freq,target,i,j+1,dp);
        long take = (freq[target.charAt(i)-'a'][j] * helper(freq,target,i+1,j+1,dp))%mod;
        return dp[i][j] = (take+notake)%mod;
    }
}