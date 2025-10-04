class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int st = 0;
        int end = 0;
        int prev = -1;
        while(end < n){
            int el = nums[end];
            if(el == 1 && prev == 1){
                st = end;
            }
            else if(el == 0 && prev == 0){
                st = end;
            }
            
            ans += end-st+1;
            prev = el;
            end++;
        }
        return ans;
    }
}