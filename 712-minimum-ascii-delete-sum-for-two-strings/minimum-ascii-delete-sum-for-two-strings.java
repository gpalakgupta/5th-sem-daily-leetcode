class Solution {
    int n1;
    int n2;

    public int minimumDeleteSum(String s1, String s2) {
        n1 = s1.length();
        n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return helper(s1, s2, 0, 0, dp);
    }

    public int helper(String s1, String s2, int i, int j, int[][] dp) {
        if (i >= n1) {
            int sum = 0;
            for (int k = j; k < n2; k++) {
                sum += (int)s2.charAt(k);
            }
            return sum;
        }

        if (j >= n2) {
            int sum = 0;
            for (int k = i; k < n1; k++) {
                sum += (int)s1.charAt(k);
            }
            return sum;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = helper(s1,s2,i+1,j+1,dp);
        }
        else{
            int a = (int)s1.charAt(i)+  helper(s1,s2,i+1,j,dp);
            int b = (int)s2.charAt(j) +  helper(s1,s2,i,j+1,dp);
            ans = Math.min(a,b);
        }
        return dp[i][j] = ans;
    }
}