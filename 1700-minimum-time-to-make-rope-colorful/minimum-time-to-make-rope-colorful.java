import java.util.Arrays;

class Solution {
    int n;
    int[][] dp;

    public int minCost(String colors, int[] neededTime) {
        n = colors.length();
        dp = new int[n][27];
        for (int[] a : dp) Arrays.fill(a, -1);
        return helper(colors, neededTime, 0, 26, 0);
    }

    public int helper(String colors, int[] need, int idx, int prevColor, int prevTime) {
        if (idx >= n) return 0;
        if (dp[idx][prevColor] != -1) return dp[idx][prevColor];

        int res;
        int currColor = colors.charAt(idx) - 'a';
        int currTime = need[idx];

        if (currColor == prevColor) {
            if (currTime < prevTime)
                res = currTime + helper(colors, need, idx + 1, prevColor, prevTime);
            else
                res = prevTime + helper(colors, need, idx + 1, currColor, currTime);
        } else {
            res = helper(colors, need, idx + 1, currColor, currTime);
        }

        return dp[idx][prevColor] = res;
    }
}
