class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        Arrays.sort(satisfaction);
        for (int[] a : dp) {
            Arrays.fill(a, -100000000);
        }
        return helper(satisfaction, 0, 1, dp);
    }

    public int helper(int[] satisfaction, int idx, int timer, int[][] dp) {
        if (idx >= satisfaction.length) {
            return 0;
        }
        if(dp[idx][timer] != -100000000){
            return dp[idx][timer];
        }
        int a = satisfaction[idx] * timer + helper(satisfaction, idx + 1, timer + 1, dp);
        int b = helper(satisfaction, idx + 1, timer, dp);

        return dp[idx][timer] = Math.max(a, b);
    }
}