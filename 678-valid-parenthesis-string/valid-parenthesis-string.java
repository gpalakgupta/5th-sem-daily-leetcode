class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
 
        // int n = s.length();
        // Boolean[][] dp = new Boolean[n][n];
        // return helper(0, 0, n, s, dp);
    }

    // public boolean helper(int idx, int cnt, int n, String str, Boolean[][] dp) {
    //     if (cnt < 0) {
    //         return false;
    //     }
    //     if (idx == n) {
    //         return cnt == 0;
    //     }
    //     if (dp[idx][cnt] != null) {
    //         return dp[idx][cnt];
    //     }
    //     char ch = str.charAt(idx);
    //     if (ch == '(') {
    //         return helper(idx + 1, cnt + 1, n, str, dp);
    //     }
    //     if (ch == ')') {
    //         return helper(idx + 1, cnt - 1, n, str, dp);
    //     }
    //     return dp[idx][cnt] = helper(idx + 1, cnt + 1, n, str, dp) || helper(idx + 1, cnt - 1, n, str, dp)
    //             || helper(idx + 1, cnt, n, str, dp);

    // }
}