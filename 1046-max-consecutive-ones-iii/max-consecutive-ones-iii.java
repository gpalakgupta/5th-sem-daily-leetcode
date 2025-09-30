class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int st = 0;
        int end = 0;
        int ans = 0;
        int zero = 0;
        while(st < n){
            int el = nums[st];
            if(el == 0){
                zero++;
            }
            while(end <= st && zero > k){
                int t = nums[end];
                if(t == 0){
                    zero--;
                }
                end++;
            }
            ans = Math.max(ans,st-end+1);
            st++;
        }
        return ans;
    }
}