class Solution {
    int n1;
    int n2;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        n1 = nums1.length;
        n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return helper(0,0,nums1,nums2,dp);
    }
    public int helper(int i, int j, int[] nums1, int[] nums2, int[][] dp){
        if(i>=n1){
            return 0;
        }
        if(j >= n2){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        if(nums1[i] == nums2[j]){
            ans = 1+helper(i+1,j+1,nums1, nums2,dp);
        }
        else{
            int a = helper(i+1,j,nums1,nums2,dp);
            int b = helper(i,j+1,nums1,nums2,dp);
            ans = Math.max(a,b);
        }
        return dp[i][j] = ans;
    }
}