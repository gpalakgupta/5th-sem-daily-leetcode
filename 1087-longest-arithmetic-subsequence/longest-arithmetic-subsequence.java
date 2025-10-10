class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int res = 0;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                int diff = nums[i]-nums[j]+500;
                dp[i][diff] = (dp[j][diff] > 0) ? dp[j][diff]+1 : 2;
                res = Math.max(res,dp[i][diff]); 
            }
        }
        return res;
    }
}