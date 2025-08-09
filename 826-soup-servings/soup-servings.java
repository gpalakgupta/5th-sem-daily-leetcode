class Solution {
    public double soupServings(int n) {
        if(n >= 5000){
            return 1;
        }
        double[][] dp = new double[n+1][n+1];
        for(double[] a : dp){
            Arrays.fill(a,-1.0);
        }
        return helper(n,n,dp);
    }
    public double helper(int a, int b, double[][] dp){
        if(a<=0 && b<= 0){
            return 0.5;
        }
        if(a<= 0){
            return 1.0;
        }
        if(b <= 0){
            return 0;
        }
        if(dp[a][b] != -1.0){
            return dp[a][b];
        }
        double prof = 0.0;
        int[][] arr = {{100,0},{75,25},{50,50},{25,75}};
        for(int[] ar : arr){
            int first = ar[0];
            int second = ar[1];
            prof += helper(a-first,b-second,dp);
        }
        return dp[a][b] = prof*.25;
    }
}