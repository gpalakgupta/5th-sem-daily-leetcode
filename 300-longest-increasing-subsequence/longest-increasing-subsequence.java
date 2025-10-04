class Solution {
    public int lengthOfLIS(int[] nums) {
        return helper(nums);
    }
    public int helper(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] > dp[len-1]){
                dp[len++] = nums[i];
            }
            else{
                int idx = search(0,len-1,nums[i],dp);
                dp[idx] = nums[i];
            }
        }
        return len;
    }
    public int search(int st, int end, int el, int[] dp){
        int ans = 0;
        while(st <= end){
            int mid  = st+(end-st)/2;
            if(dp[mid] >= el){
                ans = mid;
                end = mid-1;
            }
            else{
                st = mid+1;
            }
        }
        return ans;
    }
}