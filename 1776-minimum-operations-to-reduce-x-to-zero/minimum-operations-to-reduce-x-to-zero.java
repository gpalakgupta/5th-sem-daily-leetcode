class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int target = 0;
        for(int el : nums){
            target += el;
        }
        target -= x;
        int st = 0;
        int end = 0;
        int sum = 0;
        int mx = -1;
        while(end < n){
            sum += nums[end];
            while(st <= end && sum > target){
                sum-= nums[st];
                st++;
            }
            if(sum == target){
                mx = Math.max(mx,end-st+1);
            }
            end++;
        }
        return mx == -1 ? -1 : n-mx;
    }
}