class Solution {
    public int fruitCount(int[][] fruits){
        int count = 0;
        for(int i = 0; i<fruits.length; i++){
            count+=fruits[i][i];
        }
        return count;
    }
    public int fruits2Count(int[][] fruits, int i, int j, int[][] dp){
        int n = fruits.length;
        if(j < 0 || j > n-1 || i>n-1){
            return 0;
        }
        if(i == n-1 && j == n-1){
            return 0;
        }
        if(i == j || i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = fruits[i][j]+fruits2Count(fruits,i+1,j-1,dp);
        int b = fruits[i][j]+fruits2Count(fruits,i+1,j,dp);
        int c = fruits[i][j]+fruits2Count(fruits,i+1,j+1,dp);
        return dp[i][j] = Math.max(a,Math.max(b,c));
    }
     public int fruits3Count(int[][] fruits, int i, int j,int[][] dp){
        int n = fruits.length;
        if(i < 0 || j > n-1 || i>n-1){
            return 0;
        }
        if(i == n-1 && j == n-1){
            return 0;
        }
        if(i == j || i < j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = fruits[i][j]+fruits3Count(fruits,i-1,j+1,dp);
        int b = fruits[i][j]+fruits3Count(fruits,i,j+1,dp);
        int c = fruits[i][j]+fruits3Count(fruits,i+1,j+1,dp);
        return dp[i][j] = Math.max(a,Math.max(b,c));
    }
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int c1 = fruitCount(fruits);
        int[][] dp1 = new int[n+1][n+1];
        for(int[] a : dp1){
            Arrays.fill(a,-1);
        }
        int c2 = fruits2Count(fruits,0,n-1,dp1);
        int[][] dp2 = new int[n+1][n+1];
        for(int[] a : dp2){
            Arrays.fill(a,-1);
        }
        int c3 = fruits3Count(fruits,n-1,0,dp2);
        return c1+c2+c3;
    }
}