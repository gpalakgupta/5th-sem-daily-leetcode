class Solution {
    int n;
    int mod = 1000000007;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        n = locations.length;
        int[][] dp = new int[n][fuel+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(locations,start,finish,fuel,dp);
    }
    public int helper(int[] arr, int idx, int des, int fuel, int[][] dp){
        if(fuel <  0){
            return 0;
        }

        if(dp[idx][fuel] != -1){
            return dp[idx][fuel];
        }

        int ans = 0;
        if(idx == des){
            ans++;
        }
        for(int i = 0; i<n; i++){
            if(i != idx && Math.abs(arr[idx]-arr[i]) <= fuel){
                ans = (ans + helper(arr,i,des,fuel-Math.abs(arr[idx]-arr[i]),dp))%mod;
            }
        }
        return dp[idx][fuel] = ans;
    }
}