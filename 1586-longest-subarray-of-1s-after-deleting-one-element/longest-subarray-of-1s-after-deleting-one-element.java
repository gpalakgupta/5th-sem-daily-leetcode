class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = 0;
        int ans = 0;
        int zero = 0;
        while(end < n){
            int el = nums[end];
            if(el == 0){
                zero++;
            }
           
            while(st <= end && zero >= 2){
                int t = nums[st];
                if(t == 0){
                    zero--;
                }
                st++;
            }
           
            ans = Math.max(ans,end-st+1);
            end++;
        }
        return ans-1;
    }
}